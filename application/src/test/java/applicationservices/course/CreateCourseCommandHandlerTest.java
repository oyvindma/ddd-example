package applicationservices.course;

import applicationservices.course.CreateCourseCommand;
import applicationservices.course.CreateCourseCommandHandler;
import integrationservices.InMemoryCourseRepository;

import java.util.UUID;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class CreateCourseCommandHandlerTest {

	@Test
	public void shouldNotThrowExceptionWhenHandlingCreateCourseCommand() {
		// Given
		CreateCourseCommand createCourseCommand = new CreateCourseCommand(
				UUID.randomUUID(), "Course name");
		CreateCourseCommandHandler createCourseCommandHandler = new CreateCourseCommandHandler(
				new InMemoryCourseRepository());

		// When
		createCourseCommandHandler.handle(createCourseCommand);
	}

	@Test
	public void shouldPersistCourse() {
		// Given
		InMemoryCourseRepository courseRepository = new InMemoryCourseRepository();
		CreateCourseCommandHandler commandHandler = new CreateCourseCommandHandler(
				courseRepository);

		// When
		UUID courseId = UUID.randomUUID();
		CreateCourseCommand createCourseCommand = new CreateCourseCommand(
				courseId, "Course name");
		commandHandler.handle(createCourseCommand);

		// Then
		Assertions.assertThat(courseRepository.get(courseId)).isNotNull();
	}

}
