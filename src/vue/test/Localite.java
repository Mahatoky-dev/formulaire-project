package vue.test;
import vue.HtmlComponent;
public class Localite extends HtmlComponent {
    private String adresse;
    private String region;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
