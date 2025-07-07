package vue;

import java.util.ArrayList;

public class List extends HtmlComponent {
    public List(ArrayList<Object> data) {
        setData(data);
    }
}