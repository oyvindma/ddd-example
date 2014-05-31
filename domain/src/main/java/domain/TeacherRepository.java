package domain;
import java.util.List;
import java.util.UUID;

/**
 * Created by agjendem on 27.05.2014.
 */
public interface TeacherRepository {

    void save(Teacher teacher);

    // return the Aggregate root
	Teacher get(UUID teacherId);
	
}
