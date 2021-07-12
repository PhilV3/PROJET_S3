package Date;

import java.util.ArrayList;

public class Disponibilité {

    private ArrayList<String> dispoHoraire = new ArrayList<String>();
    private ArrayList<String> dispoReservees = new ArrayList<String>();

    public ArrayList<String> getDispoHoraire() {
        return dispoHoraire;
    }
    public ArrayList<String> getDispoReservees() {
        return dispoReservees;
    }

    public void setDispoHoraire(ArrayList<String> dispoHoraire) {
        this.dispoHoraire = dispoHoraire;
    }

    public void setDispoReservees(ArrayList<String> dispoReservees) {
        this.dispoReservees = dispoReservees;
    }
}
