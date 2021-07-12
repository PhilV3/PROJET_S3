package Mapper;

import Local.Local;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalMapper {
    public LocalMapper() {
    }
    public ArrayList<Local> mapData(ResultSet rs){
        ArrayList<Local> localMapped = new ArrayList<Local>();
        try {
            int i = 0;
            while (rs.next()) {
                localMapped.add(i,new Local(rs.getString("nom_local"), rs.getInt("capacite"), rs.getString("no_fonctions")));
                localMapped.get(i).setNo_characteristique(rs.getString("no_caracteristiques"));
                localMapped.get(i).setNotes(rs.getString("notes"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    return localMapped;
    }
}
