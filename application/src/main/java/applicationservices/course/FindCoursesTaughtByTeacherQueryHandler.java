package applicationservices.course;

import java.util.Set;
import java.util.UUID;

import applicationservices.Queries;
import domain.CourseRepository;

public class FindCoursesTaughtByTeacherQueryHandler implements Queries<FindCoursesTaughtByTeacherQuery, Set<UUID>> {

	private CourseRepository courseRepository;

	public FindCoursesTaughtByTeacherQueryHandler(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
		
	}
	
	@Override
	public Set<UUID> query(FindCoursesTaughtByTeacherQuery t) {
		return courseRepository.findCoursesToughtByTeacher(t.getTeacherId());
	}



}
