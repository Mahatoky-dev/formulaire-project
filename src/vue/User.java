package vue;

public class User extends HtmlComponent {
    private String name;
    private int age;
    private Maison maison;
    private Sexe sexe;

    public User() {
    }

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Maison getMaison() {
        return maison;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name + " a " + age + "maisson -> " + maison.toString();
    }
}
