package ca.usherbrooke.gegi.server.persistence;

import ca.usherbrooke.gegi.server.Note.Classe;
import ca.usherbrooke.gegi.server.business.Etudiant;

import ca.usherbrooke.gegi.server.business.Universite;
import ca.usherbrooke.gegi.server.business.Trimestre;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;


import java.util.List;

@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
public interface CoursMapper {

    List<Classe> select(@Param("id") Integer id);
    void insertNote(@Param("universite") Universite universite);
    void insertCours(@Param("trimestre") Trimestre trimestre);
}
