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

    public Classe(String nom, String libelle) {
        this.nom = nom;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return nom+" " +libelle+" " + listNote.toString()+"\n";
    }

    public void selectNotes(DataBase db,String cip){
        ResultSet cunt = db.selectStatement("select app.classe.libelle,classe.ap_id, commentaire,classe.competence_id,control_notes.controle_id,control_notes.note,control_notes.ponderation from app.classe,app.control_notes where classe.competence_id = control_notes.competence_id and control_notes.cip_etudiant = 'debp1101' and classe.trimestre_id = 'H21' and classe.controle_id = control_notes.controle_id order by ap_id, libelle\n");
        //System.out.println("ASPNIPAOFPOEFPOAEFPOEFPOPOEFEWFOPKPWEFOKPOKFWEEWFPOKFE\n\n\n\n\n\n\n\n\n\n\n");
        listNote.addAll(new NoteMapper().mapData(cunt));
      //  return cunt;
    }
}
