package ca.usherbrooke.gegi.server.persistence;
import ca.usherbrooke.gegi.server.Note.Classe;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;
import java.util.List;

/**
 * Interface de mappage
 */
@SuppressWarnings("CdiManagedBeanInconsistencyInspection")
@Mapper
public interface CoursMapper {
    List<Classe> select(@Param("id") Integer id);
}
