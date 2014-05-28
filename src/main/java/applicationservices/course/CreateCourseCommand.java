package applicationservices.course;

import java.util.UUID;

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
