package ca.usherbrooke.gegi.server.Personne;

import ca.usherbrooke.gegi.server.Database.DataBase;

public class Soutient extends Personne {

    public Soutient(int etudiant_app_id,String cip, String nom, String departement ){
        this.etudiant_app_id = etudiant_app_id;
        this.cip = cip;
        this.nom = nom;
        this.departement = departement;
        this.status = "Soutient";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean ajouterEtudiantToDB(DataBase db){

        return db.insertStatement("insert into etudiant_app Values("+etudiant_app_id+",'"+cip+"','"+nom+"');");

    }
}
