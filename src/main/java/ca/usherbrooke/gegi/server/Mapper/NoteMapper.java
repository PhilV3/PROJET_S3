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
            ArrayList<String> hashNomClasse = new ArrayList<String>();
            ArrayList<String> hashLibelle = new ArrayList<String>();
            int i = 0;
            while (rs.next() && rs != null) {
                noteMapper.add(new Note(rs.getString("cip_etudiant"), rs.getString("ap_id"), rs.getString("libelle"), rs.getInt("note"), rs.getInt("ponderation"), rs.getInt("competence_id")));
                i++;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return noteMapper;
        }
        return noteMapper;
    }
}
