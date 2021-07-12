package ca.usherbrooke.gegi.server.Note;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
//@JsonSerialize
public class Note {
    String cip = "";
    String nom = "";
    String titre = "";
    int note = 0;
    int ponderation = 0;
    int competence = 0;

    public Note(String cip,String nom, String titre, int notes,int ponderation, int competence) {
        this.cip = cip;
        this.nom = nom;
        this.titre = titre;
        this.note = notes;
        this.ponderation = ponderation;
        this.competence = competence;
    }

    public Note() {

    }

    @Override
    public String toString() {
        return "\t"+ note+" " + ponderation+" " + competence+"\n";
    }
}
