package integrationservices;

import java.util.UUID;

import org.fest.assertions.Assertions;
import org.junit.Test;

import domain.Student;
import domain.StudentRepository;



public class InMemoryStudentRepositoryTest {
	
	@Test
	public void shouldNotFailWhenAddingStudent() throws Exception {
		StudentRepository repo = new InMemoryStudentRepository();
		repo.save(new Student(UUID.randomUUID(), "Tanja the Student"));
	}
	
	@Test
	public void shouldRetrieveStudentAdded() throws Exception {
		
		StudentRepository repo = new InMemoryStudentRepository();
		
		UUID TeacherId = UUID.randomUUID();
		Student Teacher = new Student(TeacherId, "Tanja the Student");
		
		repo.save(Teacher);
		
		Assertions.assertThat(repo.get(TeacherId)).isEqualTo(Teacher);
	}
}
