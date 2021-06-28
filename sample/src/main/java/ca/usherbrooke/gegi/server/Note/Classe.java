package ca.usherbrooke.gegi.server.Note;

import ca.usherbrooke.gegi.server.Database.DataBase;
import ca.usherbrooke.gegi.server.Mapper.EtudiantMapper;
import ca.usherbrooke.gegi.server.Mapper.NoteMapper;
import ca.usherbrooke.gegi.server.business.Etudiant;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Classe {
    String nom = "";
    String titre = "";
    ArrayList<Note> listNote = new ArrayList<Note>();

    public Classe(String nom, String titre, ArrayList<Note> listNote) {
        this.nom = nom;
        this.titre = titre;
        this.listNote = listNote;
    }

    public Classe(String nom, String titre) {
        this.nom = nom;
        this.titre = titre;
    }

    @Override
    public String toString() {
        return nom +"'"+ titre +"'"+ listNote.toString() + "\n";
    }

    public void selectNotes(DataBase db,String cip){
        ResultSet cunt = db.selectStatement("SELECT * FROM app.notesEtudiant WHERE app.notesetudiant.cip LIKE '"+cip+"'and app.notesEtudiant.nom like '"+this.nom+"'");
        //System.out.println("ASPNIPAOFPOEFPOAEFPOEFPOPOEFEWFOPKPWEFOKPOKFWEEWFPOKFE\n\n\n\n\n\n\n\n\n\n\n");
        listNote.addAll(new NoteMapper().mapData(cunt));
      //  return cunt;
    }
}
