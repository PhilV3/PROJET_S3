package ca.usherbrooke.gegi.server.Note;

import java.util.ArrayList;

public class Note {
    String cip = "";
    String nom = "";
    String titre = "";
    ArrayList<Integer> notes = new ArrayList<Integer>();
    ArrayList<Integer> maxEval = new ArrayList<Integer>();
    int moyenne = 0;

    public Note(String cip,String nom, String titre, ArrayList<Integer> notes, ArrayList<Integer> maxEval, int moyenne) {
        this.cip = cip;
        this.nom = nom;
        this.titre = titre;
        this.notes = notes;
        this.maxEval = maxEval;
        this.moyenne = moyenne;
    }
public Note(String cip,String nom, String titre, int notes, int maxEval, int moyenne) {
        this.cip = cip;
        this.nom = nom;
        this.titre = titre;
        this.notes.add(notes);
        this.maxEval.add(maxEval);
        this.moyenne = moyenne;
    }


    public Note() {

    }

    @Override
    public String toString() {
        return nom+"'"+ titre +"'"+ notes +"'"+ maxEval +"'"+ moyenne;
    }
}
