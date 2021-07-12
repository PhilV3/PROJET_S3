package ca.usherbrooke.gegi.server.Note;

import ca.usherbrooke.gegi.server.Database.DataBase;
import ca.usherbrooke.gegi.server.Mapper.EtudiantMapper;
import ca.usherbrooke.gegi.server.Mapper.NoteMapper;
import ca.usherbrooke.gegi.server.business.Etudiant;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.ResultSet;
import java.util.ArrayList;
@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
//@JsonSerialize
public class Classe {
    String nom = "";
    String libelle = "";
    ArrayList<Note> listNote = new ArrayList<Note>();

    public Classe(String nom, String titre, ArrayList<Note> listNote) {
        this.nom = nom;
        this.libelle = titre;
        this.listNote = listNote;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle += libelle;
    }

    public Classe(String nom, String titre) {
        this.nom = nom;
        this.libelle = titre;
    }

    @Override
    public String toString() {
        return nom+" " +libelle+" " + listNote.toString()+"\n";
    }

    public void selectNotes(DataBase db,String cip){
        ResultSet cunt = db.selectStatement("SELECT libelle,control_id.ap_id,control_notes.cip_etudiant,control_notes.competence_id,control_notes.note,control_notes.ponderation FROM app.control_notes join app.classe on control_notes.cip_etudiant LIKE '"+cip+"' and classe.ap_id like '"+this.nom+"' and trimestre_id like 'H21'");
        //System.out.println("ASPNIPAOFPOEFPOAEFPOEFPOPOEFEWFOPKPWEFOKPOKFWEEWFPOKFE\n\n\n\n\n\n\n\n\n\n\n");
        listNote.addAll(new NoteMapper().mapData(cunt));
      //  return cunt;
    }
}
