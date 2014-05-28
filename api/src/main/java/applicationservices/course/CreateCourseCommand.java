package applicationservices.course;

import java.util.UUID;

// TODO: Could be generated from a Google Protocol Buffer file (.proto) - which we share as our schema with the client(s)
public class CreateCourseCommand {

	private UUID courseId;
	private String courseName;

	public CreateCourseCommand(UUID courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
	}

	public UUID getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}


}
