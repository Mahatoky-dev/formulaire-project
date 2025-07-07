import java.util.ArrayList;

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
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        //teste de l'ecriture dans le fichier
        FileObjectWriter fow = new FileObjectWriter("myFile");
        fow.initObjectInFile(new User().getClass());
        fow.writetRow("my row ---------");

        FileObjectReader fileReader = new FileObjectReader("myFile");
        String row = "vue.User::name->Mahatoky;;vue.User::age->10;;vue.Region::nom->Antananrivo;;class->vue.User;;vue.Maison::adresse->2c pres 5 c manajakaray;;";

        System.out.println(fileReader.initAllObjectUtileFromRow(row.split(";;"), "::"));
        
    }
}
