package vue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;

public class HtmlComponent {
    private ArrayList<Object> data = new ArrayList<>();

    // contruction du page html
    public String buildHtmlInsert() throws Exception {
        String html = "";
        Field[] fields = this.getClass().getDeclaredFields();
        // envoyer le nom de la classe
        html += "<input type=" + "hidden" + " name=" + "'class'" + " value='" + this.getClass().getName() + "'>";

        // ecrire le nom du champs a remplire
        for (Field field : fields) {
            Class<?> fieldClass = field.getType();
            html += "<label>" + field.getName() + " : </label> ";

            String type = "";
            if (fieldClass.getName().contains("vue")) {
                html += "<br>";
                Class<? extends HtmlComponent> classChild;
                classChild = (Class<? extends HtmlComponent>) Class.forName(fieldClass.getName());
                HtmlComponent component = classChild.newInstance();
                html += component.buildHtmlInsert();
            } else {
                if (fieldClass.equals(String.class)) {
                    type = "text";
                } else if (fieldClass.equals(int.class) || fieldClass.equals(double.class)) {
                    type = "number";
                } else if (fieldClass.equals(LocalDate.class)) {
                    type = "date";
                }
                html += "<input type=" + type + " name='" + this.getClass().getName() + "::" + field.getName()
                        + "'> <br>";
            }
        }
        html += "<br>";
        return html;
    }

    public String buildTable() {
        String htmlTable = "<table border=1>";
        if (this.data != null && data.size() > 0) {
            htmlTable += buildColumnAtributOfObject(data.get(0));

            // ecrire les ligne du tableu
            Field[] fields = data.get(0).getClass().getDeclaredFields();
            for (Object obj : data) {
                htmlTable += "<tr>";
                for (Field field : fields) {
                    htmlTable += "<td>";
                    Object valueField = getValueAtribut(field, obj);
                    if (valueField instanceof HtmlComponent) {
                        HtmlComponent component = ((HtmlComponent) valueField);
                        component.resetDataWhithObject(component);
                        htmlTable += component.buildTable();
                    } else {
                        htmlTable += valueField;
                    }
                    htmlTable += "</td>";
                }
                htmlTable += "</tr>";
            }
        }
        htmlTable += "</table>";
        return htmlTable;
    }

    // cree un tableau pour la caracteristique d'un composant
    public String buildTableAtribut() {
        String html = "<table>";
        Field[] fields = this.getClass().getDeclaredFields();
        html += buildColumnAtributOfObject(this);
        html += buidRowAtributForObject(fields, this);
        html += "</table>";

        return html;
    }

    public String buildColumnAtributOfObject(Object obj) {
        String htmlTable = "<tr>";
        Field[] fields = obj.getClass().getDeclaredFields();
        ArrayList<String> atributs = getAtribut(fields);
        for (String atribut : atributs) {
            htmlTable += "<th>";
            htmlTable += atribut;
            htmlTable += "</th>";
        }
        htmlTable += "</tr>";
        return htmlTable;
    }

    public String buidRowAtributForObject(Field[] fields, Object obj) {
        String htmlTable = "<tr>";
        for (Field field : fields) {
            htmlTable += "<td>";
            htmlTable += getValueAtribut(field, obj);
            htmlTable += "</td>";
        }
        htmlTable += "</tr>";
        return htmlTable;
    }

    private static ArrayList<String> getAtribut(Field[] fields) {
        ArrayList<String> listeAtribut = new ArrayList<>();
        for (Field field : fields) {
            listeAtribut.add(field.getName());
        }
        return listeAtribut;
    }

    private Object getValueAtribut(Field field, Object obj) {
        Object returnObj = null;
        field.setAccessible(true);
        String stringMethodeGetValue = "get" + field.getName().substring(0, 1).toUpperCase()
                + field.getName().substring(1);
        try {
            Method getValueMethod = obj.getClass().getDeclaredMethod(stringMethodeGetValue);
            returnObj = getValueMethod.invoke(obj);

        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    public ArrayList<Object> getData() {
        return data;
    }

    public void setData(ArrayList<Object> data) {
        this.data = data;
    }

    public void addData(Object obj) {
        this.data.add(obj);
    }

    public void resetDataWhithObject(Object object) {
        this.data = new ArrayList<>();
        data.add(object);
    }
}
