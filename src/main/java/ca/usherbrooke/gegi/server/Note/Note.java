package ca.usherbrooke.gegi.server.Note;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
//@JsonSerialize
public class Note {
    String cip = "";
    String nom = "";
    int note = 0;
    String libelle = "";
    int ponderation = 0;
    int competence = 0;

    public Note(String cip,String nom, String libelle, int notes,int ponderation, int competence) {
        this.cip = cip;
        this.nom = nom;
        this.note = notes;
        this.libelle = libelle;
        this.ponderation = ponderation;
        this.competence = competence;
    }

    public Note() {

    }

    public int getNote() {
        return note;
    }

    public int getCompetence() {
        return competence;
    }

    public int getPonderation() {
        return ponderation;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return "\t"+libelle +" "+ note+" " + ponderation+" " + competence+"\n";
    }
}
