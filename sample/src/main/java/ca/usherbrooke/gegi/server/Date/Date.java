package ca.usherbrooke.gegi.server.Date;
import ca.usherbrooke.gegi.server.Date.Horaire;

public class Date {

    private String date;
    private Horaire horaire;

    public String getDate() {
        return date;
    }

    public Horaire getHoraire() {
        return horaire;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHoraire(Horaire horaire) {
        this.horaire = horaire;
    }
}
