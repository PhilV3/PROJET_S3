package Personne;

import Database.DataBase;

public class Enseignant extends Personne{
    public Enseignant(int etudiant_app_id,String cip, String nom, String departement ){
        this.etudiant_app_id = etudiant_app_id;
        this.cip = cip;
        this.nom = nom;
        this.departement = departement;
        this.status = "Enseignant";
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "etudiant_app_id=" + etudiant_app_id +
                ", cip='" + cip + '\'' +
                ", nom='" + nom + '\'' +
                ", departement='" + departement + '\'' +
                '}';
    }

    public boolean ajouterEtudiantToDB(DataBase db){

        return db.insertStatement("insert into etudiant_app Values("+etudiant_app_id+",'"+cip+"','"+nom+"');");

    }


}
