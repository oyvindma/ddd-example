package applicationservices.course;

import applicationservices.Handles;
import domain.Course;
import domain.CourseRepository;
import domain.TeacherRepository;

public class AssignTeacherToCourseCommandHandler implements Handles<AssignTeacherToCourseCommand>{

	private CourseRepository courseRepository;
    private TeacherRepository teacherRepository;

    // TODO: Could be replaced with injecting the dependencies directly into Handle, using Lambdas
	public AssignTeacherToCourseCommandHandler(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
	}

	public void handle(AssignTeacherToCourseCommand command) {
        Course course = courseRepository.get(command.getCourseId());
        course.assignTeacher(teacherRepository.get(command.getTeacherId()));
        courseRepository.save(course);
	}

}
