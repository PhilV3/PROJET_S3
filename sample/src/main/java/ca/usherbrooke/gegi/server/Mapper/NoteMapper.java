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
                ArrayList<Integer> a = new ArrayList<Integer>();
                ArrayList<Integer> b = new ArrayList<Integer>();
                //    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
                a.add(rs.getInt("note1"));
                a.add(rs.getInt("note2"));
                a.add(rs.getInt("note3"));
                b.add(rs.getInt("denum1"));
                b.add(rs.getInt("denum2"));
                b.add(rs.getInt("denum3"));
                noteMapper.add(new Note(rs.getString("cip"),rs.getString("nom"),rs.getString("titre"),a,b,rs.getInt("moyenne")));
                i++;

            }
        }catch (SQLException e){
            return noteMapper;
          //  System.out.println(e.getMessage());
        }
        return noteMapper;
    }
}
