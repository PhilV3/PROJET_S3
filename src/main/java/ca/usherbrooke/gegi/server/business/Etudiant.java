package ca.usherbrooke.gegi.server.business;
import ca.usherbrooke.gegi.server.Database.DataBase;
import ca.usherbrooke.gegi.server.Mapper.ClasseMapper;
import ca.usherbrooke.gegi.server.Mapper.EtudiantMapper;
import ca.usherbrooke.gegi.server.Mapper.NoteMapper;
import ca.usherbrooke.gegi.server.Note.Classe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Etudiant {
    private Integer etudiant_app_id;
    private String cip;
    private String courriel;
    private String programme;
    private String programme_nom;
    private String app;
    private String app_titre;
    private String ap;
    private String departemen;
    private String faculte;
    private String universite;

    public Etudiant(){
    }

    /**
     *Constructeur d'étudiant complêt
     */
    public Etudiant(int etudiant_app_id, String cip, String nom, String courriel, String programme, String programme_nom, String app, String app_titre, String ap, String departement, String faculte, String universite) {
        this.etudiant_app_id = etudiant_app_id;
        this.cip = cip;
        this.courriel = courriel;
        this.programme = programme;
        this.programme_nom = programme_nom;
        this.app = app;
        this.app_titre = app_titre;
        this.ap = ap;
        this.faculte = faculte;
        this.universite = universite;
    }

    /**
     *Constructeur d'étudiants incomplêts
     */
    public Etudiant(int etudiant_app_id,String cip, String nom, String departement ){
        this.etudiant_app_id = etudiant_app_id;
        this.cip = cip;
    }

    /**
     * Retourne le numéro d'identification d'étudiant
     */
    public Integer getEtudiant_app_id() {
        return etudiant_app_id;
    }

    /**
     * Change le numéro d'identification d'étudiant
     * @param etudiant_app_id
     */
    public void setEtudiant_app_id(Integer etudiant_app_id) {
        this.etudiant_app_id = etudiant_app_id;
    }
///////////////////////// SECTION DE GETTER (OR) SETTER//////////////////////
    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getProgramme_nom() {
        return programme_nom;
    }

    public void setProgramme_nom(String programme_nom) {
        this.programme_nom = programme_nom;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApp_titre() {
        return app_titre;
    }

    public void setApp_titre(String app_titre) {
        this.app_titre = app_titre;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public String getFaculte() {
        return faculte;
    }

    public void setFaculte(String faculte) {
        this.faculte = faculte;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    @Override
    public String toString() {
        return  cip + '\'' +
                courriel + '\'' +
                programme + '\'' +
                 programme_nom + '\'' +
                app + '\'' +
                app_titre + '\'' +
                ap + '\'' +
                departemen + '\'' +
                faculte + '\'' +
                universite;
    }
    /////////////////////////////////////////////////////

    /**
     * Permet d'envoyer un nouvel étudiant dans la database connectée
     * @param db La database dans laquelle envoyer
     * @return Retourne si l'opération s'est bien passée
     */
    public boolean ajouterEtudiantToDB(DataBase db){

        return db.insertStatement("insert into etudiant_app Values("+etudiant_app_id+",'"+cip+"','"+courriel+"','"+programme+"','"+programme_nom+"','"+app+"','"+app_titre+"','"+ap+"','"+faculte+"','"+universite+"');");

    }

    /**
     * Permet de get un étudiant spécifique de la Database
     * @param db La database dans laquelle on sélectionne l'étudiant
     * @return l'étudiant
     */
    public Etudiant selectEtudiant(DataBase db){
        ResultSet cunt = db.selectStatement("SELECT * FROM app.etudiant_app WHERE app.etudiant_app.cip LIKE '"+getCip()+"' ");
        Etudiant e = new EtudiantMapper().mapData(cunt).get(0);
        return e;
    }

    /**
     * Sélectionne les classes dans lesquelles l'étudiant est présent durant une session quelconque
     * @param db La database dans laquelle faire la recherche
     * @param trimestre Le trimestre en question
     * @return Retourne la liste des cours dont l'étudiant fait parti
     */
    public ArrayList<Classe> selectClasseEtudiant(DataBase db,String trimestre){
        ResultSet cunt = db.selectStatement("select app.classe.ap_id, app.classe.libelle from app.classe,app.control_notes where app.classe.ap_id = app.control_notes.ap_id and app.control_notes.cip_etudiant = '"+getCip()+"' and app.classe.trimestre_id like '"+trimestre+"' and classe.controle_id = control_notes.controle_id order by app.classe.ap_id ;");
        ArrayList<Classe> e = new ArrayList<Classe>();
        e.addAll(new ClasseMapper().mapData(cunt));
        for (int i = 0;i<e.size();i++){
            e.get(i).selectNotes(db,getCip(),trimestre);
        }
        return e;
    }
}