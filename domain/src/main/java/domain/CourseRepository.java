package domain;

import java.util.UUID;


public interface CourseRepository {
	void save(Course teacher);

	Course get(UUID courseId);

    // or return some Aggregate root
}
