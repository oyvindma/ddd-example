package domain;
import java.util.UUID;

/**
 * Created by agjendem on 27.05.2014.
 */
public interface TeacherRepository {

	//TODO save
    void add(Teacher teacher);

	Teacher get(UUID teacherId);
}
