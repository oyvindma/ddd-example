package integrationservices;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

	@Override
	public Set<UUID> findCoursesToughtByTeacher(UUID teacherId) {
		Collection<Course> courselist = courseMap.values();
		Set<UUID> coursesTaughtByTeacher = new HashSet<UUID>();
		for(Course c : courselist){
			if(c.isHeldByTeacher(teacherId)){
				coursesTaughtByTeacher.add(c.getCourseId());
			}
		}
		
		return coursesTaughtByTeacher;
	}

}
