package ca.usherbrooke.gegi.server.Local;

import ca.usherbrooke.gegi.server.Database.DataBase;
import ca.usherbrooke.gegi.server.Date.Date;

import java.sql.SQLException;

public class Local {
    private String no_local;
    private int capacite;
    private String no_fonction;
    private String no_characteristique = "";
    private String notes = "";
    private HoraireLocal  horaireLocal = new HoraireLocal();

    public Local(String no_local, int capacite, String no_fonction) {
        this.no_local = no_local;
        this.capacite = capacite;
        this.no_fonction = no_fonction;
    }

    @Override
    public String toString() {
        return "Local{" +
                "no_local='" + no_local + '\'' +
                ", capacite=" + capacite +
                ", no_fonction='" + no_fonction + '\'' +
                ", no_characteristique='" + no_characteristique + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    public void setNo_characteristique(String no_characteristique) {
        this.no_characteristique = no_characteristique;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean ajouterLocalToDB(DataBase db){

        return db.insertStatement("insert into locaux Values('"+no_local+"',"+capacite+",'"+no_fonction+"','"+no_characteristique+"','"+notes+"');");

    }


}
