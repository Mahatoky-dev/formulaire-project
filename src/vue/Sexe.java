package vue;

public class Sexe extends HtmlSelect {
    private String valeur;
    public Sexe() {
        addOption("0", "Vavy");
        addOption("1", "Lahy");
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
}
