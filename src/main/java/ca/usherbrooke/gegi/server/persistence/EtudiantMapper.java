package ca.usherbrooke.gegi.server.persistence;
import ca.usherbrooke.gegi.server.business.Etudiant;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;
import java.util.List;


/**
 * Interface de mappage
 */
@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
public interface EtudiantMapper {
    List<Etudiant> select(@Param("id") Integer id);
}
