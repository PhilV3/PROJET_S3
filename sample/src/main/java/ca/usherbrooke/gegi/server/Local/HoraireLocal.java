package ca.usherbrooke.gegi.server.Local;

import ca.usherbrooke.gegi.server.Date.Date;

import java.util.ArrayList;

public class HoraireLocal {
    private ArrayList<Date> dispoLocal = new ArrayList<Date>();
    private java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

    public java.sql.Date getDate() {
        return date;
    }

    public ArrayList<Date> getDispoLocal() {
        return dispoLocal;
    }
}
