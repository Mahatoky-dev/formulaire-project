package vue;

public class Region extends HtmlComponent{
    private String nom;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Region(String nom) {
        this.nom = nom;
    }
    public Region() {
        
    }

    @Override
    public String toString() {
        return nom;
    }
}
