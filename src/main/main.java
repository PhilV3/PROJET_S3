package main;
import Database.ConnectionDatabase;
import Database.DataBase;
import Local.Local;
import Mapper.EtudiantMapper;
import Mapper.LocalMapper;
import Personne.Etdiant;

import java.sql.ResultSet;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        DataBase d = new DataBase();
        ArrayList<Etdiant> listeEtudiant = new ArrayList<Etdiant>();
        ResultSet rs = d.selectStatement("select * from app.etudiant_app;");
        listeEtudiant = new EtudiantMapper().mapData(rs);
        System.out.println(listeEtudiant);


    }
}
