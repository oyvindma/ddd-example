package integrationservices;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import domain.Teacher;
import domain.TeacherRepository;

public class InMemoryTeacherRepository implements TeacherRepository {

	private Map<UUID, Teacher> teacherRepository = new HashMap<UUID, Teacher>();

	public void save(Teacher teacher) {
		teacherRepository.put(teacher.getTeacherID(), teacher);
	}

	public Teacher get(UUID teacherId) {
		return teacherRepository.get(teacherId);
	}

}
