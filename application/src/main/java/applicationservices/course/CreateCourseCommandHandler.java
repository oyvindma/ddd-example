package applicationservices.course;

import domain.Course;
import domain.CourseRepository;
import applicationservices.Handles;

public class CreateCourseCommandHandler implements Handles<CreateCourseCommand>{

	private CourseRepository courseRepository;

    // TODO: Could be replaced with injecting the dependencies directly into Handle, using Lambdas
	public CreateCourseCommandHandler(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
	}

	public void handle(CreateCourseCommand command) {
		courseRepository.save(new Course(command.getCourseId(), command.getCourseName()));
	}

}
