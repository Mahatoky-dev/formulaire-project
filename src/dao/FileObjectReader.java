package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class FileObjectReader extends FileObject {

    public FileObjectReader(String fileName) {
        setFileName(fileName);
    }

    public ArrayList<Object> getAllObjectFormFile() {
        ArrayList<Object> listeObjects = new ArrayList<>();
        if(fileExiste() && !fileIsEmpty()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(this.getFileName()));
                String line = "";
                while((line = br.readLine()) != null) {
                    Object object = getObjectFromRow(line);
                    listeObjects.add(object);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listeObjects;
    }

    public Object getObjectFromRow(String row) {
        String[] rowSpits = row.split(";;");
        ArrayList<Object> allObjects = getAllObjectUtileFromRow(rowSpits, "::");
        String nameMotherClass = getStringWhithCaract(rowSpits, "class").get(0);
        nameMotherClass = nameMotherClass.split("->")[1];
        Class<?> motherClass;
        try {
            motherClass = Class.forName(nameMotherClass);
            Object object = getInstanceOfClasseFromArray(allObjects, motherClass);
            return object;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object getInstanceOfClasseFromArray(ArrayList<Object> allObjects, Class<?> class1) {
        for (Object obj : allObjects) {
            if (obj.getClass().equals(class1)) {
                return obj;
            }
        }
        return null;
    }

    public ArrayList<String> getStringWhithCaract(String[] tab, String caract) {
        ArrayList<String> arrayWithCaract = new ArrayList<>();
        for (String string : tab) {
            if (string.contains(caract)) {
                arrayWithCaract.add(string);
            }
        }
        return arrayWithCaract;
    }

    public ArrayList<Object> getAllObjectUtileFromRow(String[] tab, String splits) {
        ArrayList<Object> listeObject = new ArrayList<>();
        ArrayList<String> distinctStringClass = getDistictStringClass(tab, splits);

        for (String nameClasse : distinctStringClass) {
            try {
                try {
                    listeObject.add(Class.forName(nameClasse).newInstance());
                } catch (InstantiationException | IllegalAccessException e) {

                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // initialiser les atribus primitive pour chaque object
        for (Object obj : listeObject) {
            initPrimitiveValeur(obj, tab);
            initObjectValeur(listeObject.toArray(), obj);
        }
        return listeObject;
    }

    public ArrayList<String> getDistictStringClass(String[] tab, String splits) {
        ArrayList<String> distinctStringClass = new ArrayList<>();
        for (String string : tab) {
            String[] sousTab = string.split(splits);
            if (sousTab.length > 0 && !distinctStringClass.contains(sousTab[0]) && string.contains(splits)) {
                String nameClass = sousTab[0];
                distinctStringClass.add(nameClass);
            }
        }
        return distinctStringClass;
    }

    public void initPrimitiveValeur(Object object, String[] tab) {
        Field[] fieldsObject = object.getClass().getDeclaredFields();

        // recherecher dans la tab la valeur a affecter
        for (Field field : fieldsObject) {
            field.setAccessible(true);
            for (String string : tab) {
                if (string.contains(field.getName()) &&
                        string.contains(object.getClass().getSimpleName())
                        && string.contains("->")) {
                    String[] sousTab = string.split("->");
                    if (sousTab.length > 0) {
                        try {
                            if (field.getType().equals(String.class)) {
                                field.setAccessible(true);
                                field.set(object, sousTab[1]);
                            }
                            if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
                                field.set(object, Integer.parseInt(sousTab[1]));
                            }
                        } catch (IllegalArgumentException | IllegalAccessException e) {

                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void initObjectValeur(Object[] objectReferences, Object obj) {
        Field fields[] = obj.getClass().getDeclaredFields();

        // instantier dans l'object ceux du meme type dans objectReference
        for (Field field : fields) {
            field.setAccessible(true);
            for (Object objReference : objectReferences) {
                if (field.getType().equals(objReference.getClass())) {
                    try {
                        field.set(obj, objReference);
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
