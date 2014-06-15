package applicationservices.course;

import java.util.UUID;

public class FindCoursesTaughtByTeacherQuery {

	private UUID teacherId;


	public FindCoursesTaughtByTeacherQuery(UUID teacherId) {
		this.teacherId = teacherId;
	}

	public UUID getTeacherId() {
		return teacherId;
	}

}

