package Mapper;

import Local.Local;
import Personne.Etdiant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EtudiantMapper {
    public ArrayList<Etdiant> mapData(ResultSet rs){
        ArrayList<Etdiant> etdiantMapper = new ArrayList<Etdiant>();
        try {
            int i = 0;
            while (rs.next() && rs != null) {
                etdiantMapper.add(i,new Etdiant(rs.getInt("etudiant_app_id"), rs.getString("cip"), rs.getString("nom"), rs.getString("courriel"), rs.getString("programme"), rs.getString("programme_nom"), rs.getString("app"), rs.getString("app_titre"), rs.getString("ap"), rs.getString("departement"), rs.getString("faculte"), rs.getString("universite")));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return etdiantMapper;
    }
}
