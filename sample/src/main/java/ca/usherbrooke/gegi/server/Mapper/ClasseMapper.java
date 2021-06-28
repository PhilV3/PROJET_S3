package ca.usherbrooke.gegi.server.Mapper;

import ca.usherbrooke.gegi.server.Note.Classe;
import ca.usherbrooke.gegi.server.Note.Note;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClasseMapper {
    public ArrayList<Classe> mapData(ResultSet rs){
        ArrayList<Classe> classeMapper = new ArrayList<Classe>();
        try {
            while (rs.next() && rs != null) {
                classeMapper.add(new Classe(rs.getString("nom"),rs.getString("titre")));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return classeMapper;
    }
}
