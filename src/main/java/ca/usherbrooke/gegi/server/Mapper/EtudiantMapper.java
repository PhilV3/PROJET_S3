package ca.usherbrooke.gegi.server.Mapper;

import ca.usherbrooke.gegi.server.business.Etudiant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EtudiantMapper {
    public ArrayList<Etudiant> mapData(ResultSet rs){
        ArrayList<Etudiant> etdiantMapper = new ArrayList<Etudiant>();
        try {
            while (rs.next() && rs != null) {
                etdiantMapper.add(new Etudiant(rs.getInt("etudiant_app_id"), rs.getString("cip"), rs.getString("nom"), rs.getString("courriel"), rs.getString("programme"), rs.getString("programme_nom"), rs.getString("app"), rs.getString("app_titre"), rs.getString("ap"), rs.getString("departement"), rs.getString("faculte"), rs.getString("universite")));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return etdiantMapper;
    }
}
