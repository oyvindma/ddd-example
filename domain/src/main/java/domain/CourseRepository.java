package domain;

import java.util.UUID;


public interface CourseRepository {
	void save(Course teacher);

    // return the Aggregate root
	Course get(UUID courseId);
}
