package integrationservices;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import domain.Course;
import domain.Student;
import domain.StudentRepository;

public class InMemoryStudentRepository implements StudentRepository {

	Map<UUID, Student> studentMap = new HashMap<UUID, Student>();
	
	public void save(Student student) {
		studentMap.put(student.getStudentId(), student);
	}

	public Student get(UUID studentId) {
		return studentMap.get(studentId);
	}

}
