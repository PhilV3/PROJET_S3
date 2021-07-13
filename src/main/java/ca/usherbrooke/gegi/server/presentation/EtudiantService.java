package ca.usherbrooke.gegi.server.presentation;

import ca.usherbrooke.gegi.server.Database.DataBase;
import ca.usherbrooke.gegi.server.Note.Classe;
import ca.usherbrooke.gegi.server.injection.loadSassyroboyt;
import ca.usherbrooke.gegi.server.persistence.CoursMapper;
import ca.usherbrooke.gegi.server.persistence.EtudiantMapper;
import ca.usherbrooke.gegi.server.business.Etudiant;
import org.jasig.cas.client.authentication.AttributePrincipalImpl;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("")
public class EtudiantService {

    @Context
    HttpServletRequest httpServletRequest;
    DataBase db = new DataBase();
    boolean careDate = false;

    @Inject
    EtudiantMapper etudiantMapper;
    CoursMapper coursMapper;

    /**
     * Retourne un étudiant à l'aide d'un Json
     * @param id Identification d'un élève
     * @return Retourne un étudiant
     */
    @GET
    @Path("etudiant")
    @Produces("application/json")
    public List<Etudiant> getEtudiant(@QueryParam("id") Integer id) {
        Principal principal = httpServletRequest.getUserPrincipal();
        Etudiant etudiant = new Etudiant();
        etudiant.setCip(principal.getName());
        List<Etudiant> etudiants = etudiantMapper.select(id);
        return etudiants;
    }

    /**
     * Sélectionnes les notes, les cours ainsi que toutes informations utiles dans le rendering de l'application
     * @param id Id d'identification de l'étudiant
     * @return Retourne le tableau de cours contenant les notes
     */
    @GET
    @Path("note")
    @Produces("application/json")
    public  List<Classe> getNote(@QueryParam("id") Integer id) {
        ArrayList<Classe> classes = new ArrayList<Classe>();
        classes.addAll(getUser(id).selectClasseEtudiant(db,getTrimestre()));
        return classes;
    }

    /**
     * Fonction qui récupère les données d'un utilisateur
     * @param id Le cip/id qui permet d'identifier un élève
     * @return Retourne l'étudiant ainsi que ses valeurs
     */
    @GET
    @Path("user")
    @Produces("text/plain")
      public Etudiant getUser(@QueryParam("id") Integer id) {
        Principal principal = httpServletRequest.getUserPrincipal();
        Map<String,Object> details = (Map<String,Object>) ((AttributePrincipalImpl)principal).getAttributes();
        Etudiant etudiant = new Etudiant();
        etudiant.setCip(principal.getName());
        etudiant =  etudiant.selectEtudiant(db);
       // System.out.println(etudiant);
        return etudiant;
    }

    /**
     * Fonction qui permet de sélectionner le trimestre présent
     * @return Le trimestre_id du trimestre désiré
     */
    @GET
    @Path("trim")
    public String getTrimestre(){
        if (careDate) {
            ResultSet trim = db.selectStatement("select trimestre_id from app.trimestre where now() between debut and fin;");
            try {
                while (trim.next()) {
                    String trimestre = trim.getString("trimestre_id");
                    System.out.println(trimestre);
                    return trimestre;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("Bravo, t'es bon pour faire planter du monde");
            }
        }
        return "H21";
    }

    /**
     * Fonction qui permet le changement de visionnement de session scolaire et de leurs notes
     * @param id id de l'étudiant
     * @param trimestre Trimestre auquel on veut accéder les notes
     * @return Retourne les cours et résultats asssociés
     */
    @GET
    @Path("change_session")
    @Produces("application/json")
    public List<Classe> changeSession(@QueryParam("id") Integer id, String trimestre){
        ArrayList<Classe> classes = new ArrayList<Classe>();
        classes.addAll(getUser(id).selectClasseEtudiant(db,trimestre));
        return classes;
    }

    /**
     * Fonction qui sert de motivation/amusement aux élèves
     * @param note Note présente de l'étudiant
     * @param tendance Tendance dy/dx que l'étudiant suit présentement
     * @return retouurne un string de motivation
     */
    @GET
    @Path("sass")
    public String sassyResponses(int note,int tendance){
        loadSassyroboyt a = new loadSassyroboyt();
        if(note < 50){
            if (tendance <0){
                a.sendSass(0);
            }else {
                a.sendSass(1);
            }
         }else if (note < 60){
            if (tendance < 0){
                a.sendSass(1);
            }else{
                a.sendSass(2);
            }
        }else if (note < 75){
            if (tendance < 0){
                a.sendSass(2);
            }else{
                a.sendSass(3);
            }
        }else if (note < 85){
            if (tendance < 0){
                a.sendSass(3);
            }else{
                a.sendSass(4);
            }
        }else {
            if (tendance < 0){
                a.sendSass(3);
            }else{
                a.sendSass(5);
            }
            //qui est surpris
        }

        return "";
    }

}
