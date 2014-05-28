package applicationservices.course;

import domain.Course;
import integrationservices.InMemoryCourseRepository;
import applicationservices.Handles;

public class CreateCourseCommandHandler implements Handles<CreateCourseCommand>{

	private InMemoryCourseRepository inMemoryCourseRepository;

	public CreateCourseCommandHandler(
			InMemoryCourseRepository inMemoryCourseRepository) {
				this.inMemoryCourseRepository = inMemoryCourseRepository;
	}

	public void handle(CreateCourseCommand command) {
		inMemoryCourseRepository.save(new Course(command.getCourseId(), command.getCourseName()));
	}

}
