package vue;

public class Maison extends HtmlComponent {
    private String adresse;
    private  Region region;

    public Maison( String adresse) {
        this.adresse = adresse;
    }
    public Maison() {

    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "maisson a : " + adresse + " region d' " + region;
    }
}
