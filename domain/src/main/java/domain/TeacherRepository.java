package domain;
import java.util.UUID;

/**
 * Created by agjendem on 27.05.2014.
 */
public interface TeacherRepository {

    void save(Teacher teacher);

	Teacher get(UUID teacherId);

    // or return some Aggregate root
}
