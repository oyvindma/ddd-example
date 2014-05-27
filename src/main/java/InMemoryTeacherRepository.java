import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class InMemoryTeacherRepository implements TeacherRepository  {

	private Map<UUID, Teacher> teacherRepository = new HashMap<UUID, Teacher>();
	
	public void add(Teacher teacher) {
		teacherRepository.put(teacher.getTeacherID(), teacher);
	}

	public Teacher get(UUID teacherId) {
		return teacherRepository.get(teacherId);
	}
	
	

}
