package applicationservices.course;

import java.util.UUID;

// TODO: Could be generated from a Google Protocol Buffer file (.proto) - which we share as our schema with the client(s)
public class CreateCourseCommand {

	private UUID courseId;
	private String couseName;

	public CreateCourseCommand(UUID courseId, String couseName) {
		this.courseId = courseId;
		this.couseName = couseName;
	}

	public UUID getCourseId() {
		return courseId;
	}

	public String getCouseName() {
		return couseName;
	}


}
