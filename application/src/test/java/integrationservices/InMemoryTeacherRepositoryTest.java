package integrationservices;

import java.util.UUID;

import org.fest.assertions.Assertions;
import org.junit.Test;

import domain.Teacher;
import domain.TeacherRepository;



public class InMemoryTeacherRepositoryTest {
	
	@Test
	public void shouldNotFailWhenAddingTeacher() throws Exception {
		TeacherRepository repo = new InMemoryTeacherRepository();
		repo.save(new Teacher(UUID.randomUUID(), "Tanja the Teacher", 1));
	}
	
	@Test
	public void shouldRetrieveTeacherAdded() throws Exception {
		
		TeacherRepository repo = new InMemoryTeacherRepository();
		
		UUID teacherId = UUID.randomUUID();
		Teacher teacher = new Teacher(teacherId, "Tanja the Teacher", 26);
		
		repo.save(teacher);
		
		Assertions.assertThat(repo.get(teacherId)).isEqualTo(teacher);
	}
}
