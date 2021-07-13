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
    //
    public Classe(String nom, String titre, ArrayList<Note> listNote) {
        this.nom = nom;
        this.libelle = titre;
        this.listNote = listNote;
    }
    public String getNom(){return nom;}

    public ArrayList<Note> getListNote() {
        return listNote;
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
        return nom +" "+ listNote.toString()+"\n";
    }

    /**
     * fonciton de sélection des notes en provenance de la database
     * @param db La database dans laquelle faire la recherche
     * @param cip Le cip de l'étudiant en question
     * @param trimestre Le trimestre dont la recherche est situé
     */
    public void selectNotes(DataBase db,String cip,String trimestre){
        ResultSet cunt = db.selectStatement("select app.classe.libelle, app.control_notes.cip_etudiant ,app.classe.ap_id,app.control_notes.commentaire,app.classe.competence_id,app.control_notes.controle_id,app.control_notes.note,app.control_notes.ponderation from app.classe,app.control_notes where classe.competence_id = control_notes.competence_id and control_notes.cip_etudiant = '"+cip+"' and classe.trimestre_id = '"+trimestre+"' and classe.controle_id = control_notes.controle_id order by ap_id, libelle;");
        listNote.addAll(new NoteMapper().mapData(cunt));
    }
}
