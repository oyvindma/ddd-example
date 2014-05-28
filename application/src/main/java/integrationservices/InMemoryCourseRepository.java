package integrationservices;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import domain.Course;
import domain.CourseRepository;

public class InMemoryCourseRepository implements CourseRepository {

	private Map<UUID, Course> courseMap = new HashMap<UUID, Course>();

	public void save(Course course) {
		courseMap.put(course.getCourseId(), course);
	}

	public Course get(UUID courseId) {
		return courseMap.get(courseId);
	}

}
