package ca.usherbrooke.gegi.server.business;
import ca.usherbrooke.gegi.server.Database.DataBase;
import ca.usherbrooke.gegi.server.Mapper.EtudiantMapper;

import java.sql.ResultSet;

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
    public Etudiant(int etudiant_app_id,String cip, String nom, String departement ){
        this.etudiant_app_id = etudiant_app_id;
        this.cip = cip;
    }
    public Integer getEtudiant_app_id() {
        return etudiant_app_id;
    }

    public void setEtudiant_app_id(Integer etudiant_app_id) {
        this.etudiant_app_id = etudiant_app_id;
    }

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
        return "Etudiant{" +
                "etudiant_app_id=" + etudiant_app_id +
                ", cip='" + cip + '\'' +
                ", courriel='" + courriel + '\'' +
                ", programme='" + programme + '\'' +
                ", programme_nom='" + programme_nom + '\'' +
                ", app='" + app + '\'' +
                ", app_titre='" + app_titre + '\'' +
                ", ap='" + ap + '\'' +
                ", departemen='" + departemen + '\'' +
                ", faculte='" + faculte + '\'' +
                ", universite='" + universite + '\'' +
                '}';
    }
    public boolean ajouterEtudiantToDB(DataBase db){

        return db.insertStatement("insert into etudiant_app Values("+etudiant_app_id+",'"+cip+"','"+courriel+"','"+programme+"','"+programme_nom+"','"+app+"','"+app_titre+"','"+ap+"','"+faculte+"','"+universite+"');");

    }
    public Etudiant selectEtudiant(DataBase db){
        ResultSet cunt = db.selectStatement("SELECT * FROM app.etudiant_app WHERE app.etudiant_app.cip LIKE '"+getCip()+"' ");
        Etudiant e = new EtudiantMapper().mapData(cunt).get(0);
        return e;
    }
}