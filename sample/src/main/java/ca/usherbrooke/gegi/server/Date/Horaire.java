package ca.usherbrooke.gegi.server.Date;

import java.util.ArrayList;
import ca.usherbrooke.gegi.server.Date.Disponibilité;

public class Horaire {

    private ArrayList<Disponibilité> dispoDate = new ArrayList<Disponibilité>();

    public ArrayList<Disponibilité> getDispoDate() {
        return dispoDate;
    }

    public void setDispoDate(ArrayList<Disponibilité> dispoDate) {
        this.dispoDate = dispoDate;
    }
    /**    public Horaire(String date) {
        if (date.isEmpty() || date.isBlank()){
            String k[] = date.split("-");
                try {
                    this.annee = Integer.parseInt(k[0]);
                    this.mois = Integer.parseInt(k[1]);
                    this.jour = Integer.parseInt(k[2]);
                }catch (NumberFormatException e) {
                    System.out.println("La date est mauvaise");
                }
            }
        }
 */
}
