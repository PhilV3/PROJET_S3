package ca.usherbrooke.gegi.server.Personne;

public class Personne {
    protected int etudiant_app_id;
    protected String cip;
    protected String nom;
    protected String departement;
    protected String status;
    public int getEtudiant_app_id() {
        return etudiant_app_id;
    }

    public String getCip() {
        return cip;
    }

    public String getNom() {
        return nom;
    }

    public String getDepartement() {
        return departement;
    }

    public Personne() {
    }

    @Override
    public String toString() {
        return "Personne{" +
                "etudiant_app_id=" + etudiant_app_id +
                ", cip='" + cip + '\'' +
                ", nom='" + nom + '\'' +
                ", departement='" + departement + '\'' +
                '}';
    }
}
