import static org.junit.Assert.*;

import java.util.UUID;

import org.fest.assertions.Assertions;
import org.junit.Test;



public class InMemoryTeacherRepositoryTest {
	
	@Test
	public void shouldNotFailWhenAddingTeacher() throws Exception {
		TeacherRepository repo = new InMemoryTeacherRepository();
		repo.add(new Teacher(UUID.randomUUID(), "Tanja the Teacher"));
	}
	
	@Test
	public void shouldRetrieveTeacherAdded() throws Exception {
		
		TeacherRepository repo = new InMemoryTeacherRepository();
		
		UUID teacherId = UUID.randomUUID();
		Teacher teacher = new Teacher(teacherId, "Tanja the Teacher");
		
		repo.add(teacher);
		
		Assertions.assertThat(repo.get(teacherId)).isEqualTo(teacher);
	}
}
