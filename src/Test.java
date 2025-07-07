import dao.*;
import vue.*;
public class Test {
    public static void main(String[] args) {
        
        //  Maison maison = new Maison("mon adresse ");
        // User user7 = new User("bema",10);
        // User user1 = new User("bema1",14);
        // User user2 = new User("bema2",12);
        // user7.setMaison(maison);
        // user1.setMaison(maison);
        // user2.setMaison(maison);
        // ArrayList<Object> users = new ArrayList<>();
        // users.add(user7);
        // users.add(user1);
        // users.add(user2);
        // List list = new List(users);
        // try {
        //     System.out.println(user1.buildHtmlInsert());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        //teste de l'ecriture dans le fichier
        FileObjectWriter fow = new FileObjectWriter("myFile");
        fow.initObjectInFile(new User().getClass());
        fow.writetRow("my row ---------");

        FileObjectReader fileReader = new FileObjectReader("listeObject");

        System.out.println(fileReader.getAllObjectFormFile());
    }
}
