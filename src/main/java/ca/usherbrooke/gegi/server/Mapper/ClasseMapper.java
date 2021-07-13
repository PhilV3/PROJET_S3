package ca.usherbrooke.gegi.server.Mapper;

import ca.usherbrooke.gegi.server.Note.Classe;
import ca.usherbrooke.gegi.server.Note.Note;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClasseMapper {
    /**
     * Map les classes et crée les mets dans une liste
     * @param rs Le result set contement les classes
     * @return L'array contenant les classes
     */
    public ArrayList<Classe> mapData(ResultSet rs){
        ArrayList<Classe> classeMapper = new ArrayList<Classe>();
        ArrayList<String> hashmap = new ArrayList<String>();
        ArrayList<String> hashmap2 = new ArrayList<String>();
        try {
            while (rs.next() && rs != null ) {
                if (!hashmap.contains(rs.getString("ap_id"))) {
                    classeMapper.add(new Classe(rs.getString("ap_id"), rs.getString("libelle")));
                    hashmap.add(rs.getString("ap_id"));
                    hashmap2.clear();
                    hashmap2.add(rs.getString("libelle"));

                }else {
                    if (!hashmap2.contains(rs.getString("libelle"))) {
                        classeMapper.get(classeMapper.size() - 1).setLibelle(" " + rs.getString("libelle"));
                        hashmap2.add(rs.getString("libelle"));
                    }
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return classeMapper;
    }
}
