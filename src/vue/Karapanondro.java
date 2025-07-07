package vue;

import java.time.LocalDate;

public class Karapanondro extends HtmlComponent {
    private int id;
    private LocalDate date;
    private Sexe sexe;

    public Karapanondro() {
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Sexe getSexe() {
        return sexe;
    }
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
}
