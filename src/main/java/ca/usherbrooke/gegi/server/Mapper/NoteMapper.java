package ca.usherbrooke.gegi.server.Mapper;

import ca.usherbrooke.gegi.server.Note.Note;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class NoteMapper {
    public ArrayList<Note> mapData(ResultSet rs){
        ArrayList<Note> noteMapper = new ArrayList<Note>();
        try {
            int i = 0;
            while (rs.next() && rs != null) {
                //    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
                noteMapper.add(new Note(rs.getString("cip_etudiant"),rs.getString("ap_id"),rs.getString("libelle"),rs.getInt("note"),rs.getInt("ponderation"),rs.getInt("competence_id")));
                i++;

            }
        }catch (SQLException e){
            return noteMapper;
          //  System.out.println(e.getMessage());
        }
        return noteMapper;
    }
}
