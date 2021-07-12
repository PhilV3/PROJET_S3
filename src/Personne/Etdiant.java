package Personne;

import Database.DataBase;
import Mapper.EtudiantMapper;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

public class Etdiant extends Personne{
    private String courriel= " ";
    private String programme= " ";
    private String programme_nom= " ";
    private String app= " ";
    private String app_titre= " ";
    private String ap = " ";
    private String faculte= " ";
    private String universite= " ";

    public Etdiant(int etudiant_app_id, String cip, String nom, String courriel, String programme, String programme_nom, String app, String app_titre, String ap, String departement, String faculte, String universite) {
        this.etudiant_app_id = etudiant_app_id;
        this.cip = cip;
        this.nom = nom;
        this.courriel = courriel;
        this.programme = programme;
        this.programme_nom = programme_nom;
        this.app = app;
        this.app_titre = app_titre;
        this.ap = ap;
        this.departement = departement;
        this.faculte = faculte;
        this.universite = universite;
        this.status = "Etudiant";
    }
    public Etdiant(int etudiant_app_id,String cip, String nom, String departement ){
        this.etudiant_app_id = etudiant_app_id;
        this.cip = cip;
        this.nom = nom;
        this.departement = departement;
        this.status = "Etudiant";
    }

    @Override
    public String toString() {
        return "Etdiant{" +
                "etudiant_app_id=" + etudiant_app_id +
                ", cip='" + cip + '\'' +
                ", nom='" + nom + '\'' +
                ", courriel='" + courriel + '\'' +
                ", programme='" + programme + '\'' +
                ", programme_nom='" + programme_nom + '\'' +
                ", app='" + app + '\'' +
                ", app_titre='" + app_titre + '\'' +
                ", ap='" + ap + '\'' +
                ", departement='" + departement + '\'' +
                ", faculte='" + faculte + '\'' +
                ", universite='" + universite + '\'' +
                '}';
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public void setApp_titre(String app_titre) {
        this.app_titre = app_titre;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public void setFaculte(String faculte) {
        this.faculte = faculte;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setProgramme_nom(String programme_nom) {
        this.programme_nom = programme_nom;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public boolean ajouterEtudiantToDB(DataBase db){

        return db.insertStatement("insert into app.etudiant_app Values("+etudiant_app_id+",'"+cip+"','"+nom+"','"+courriel+"','"+programme+"','"+programme_nom+"','"+app+"','"+app_titre+"','"+ap+"','"+departement+"','"+faculte+"','"+universite+"');");

    }

}
