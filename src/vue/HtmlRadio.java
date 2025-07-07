package vue;

import java.util.HashMap;
import java.util.Map;

public class HtmlRadio extends HtmlComponent {
    private String selectedItems = "none";
    private HashMap<String, String> radios = new HashMap<>();

    @Override
    public String buildHtmlInsert() {
        String html = "";
        for (Map.Entry<String, String> entry : radios.entrySet()) {
            html += "<input type='radio' name= " + this.getClass().getName() + " value='" + entry.getKey() + "'>"
                    + entry.getValue() + "<br>";
        }
        return html;
    }

    public void addRadio(String key,String value) {
        this.radios.put(key, value);
    }
}