package ca.usherbrooke.gegi.server.Personne;

import ca.usherbrooke.gegi.server.Database.DataBase;

public class Administrateur extends Personne{
    public Administrateur(int etudiant_app_id,String cip, String nom, String departement ) {
        this.etudiant_app_id = etudiant_app_id;
        this.cip = cip;
        this.nom = nom;
        this.departement = departement;
        this.status = "Administrateur";
    }

    public boolean ajouterAdmintoDB(DataBase db){

        return db.insertStatement("insert into etudiant_app Values("+etudiant_app_id+",'"+cip+"','"+nom+"');");
    }

    @Override
    public String toString() {
        return "Administrateur{" +
                "etudiant_app_id=" + etudiant_app_id +
                ", cip='" + cip + '\'' +
                ", nom='" + nom + '\'' +
                ", departement='" + departement + '\'' +
                '}';
    }
}
