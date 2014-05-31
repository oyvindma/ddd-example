package integrationservices;

import java.util.UUID;

import org.fest.assertions.Assertions;
import org.junit.Test;

import domain.Course;
import domain.CourseRepository;

public class InMemoryCourseRepositoryTest {

	@Test
	public void shouldNotFailWhenAddingClass() throws Exception {
		CourseRepository repo = new InMemoryCourseRepository();
		repo.save(new Course(UUID.randomUUID(), "Chemics course"));
	}

	@Test
	public void shouldRetrieveTeacherAdded() throws Exception {

		CourseRepository repo = new InMemoryCourseRepository();

		UUID courseId = UUID.randomUUID();
		Course course = new Course(courseId, "C#-course");

		repo.save(course);

		Assertions.assertThat(repo.get(courseId)).isEqualTo(course);
	}
	
}
