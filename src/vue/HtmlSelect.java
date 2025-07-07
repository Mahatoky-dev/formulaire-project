package vue;

import java.util.HashMap;
import java.util.Map;

public class HtmlSelect extends HtmlComponent {

    private HashMap<String,String> option;

    public void addOption(String key,String value) {
        if(option == null) {
            this.option = new HashMap<>();
        }

        option.put(key, value);
    }
    @Override
    public String buildHtmlInsert() {
        String html = "<select name="+ this.getClass().getName() + "::" + this.getClass().getDeclaredFields()[0].getName() + " >";
        for(Map.Entry<String , String> entry : this.option.entrySet()) {
            html += "<option value=" + entry.getKey() + ">";
            html += entry.getValue();
            html += "</option>";
        }
        html += "</select>";
        return html;
    }
}
