package applicationservices.course;

import java.util.UUID;

// TODO: Could be generated from a Google Protocol Buffer file (.proto) - which we share as our schema with the client(s)
public class AssignTeacherToCourseCommand {

	private UUID courseId;
	private UUID teacherId;

	public AssignTeacherToCourseCommand(UUID courseId, UUID teacherId) {
		this.courseId = courseId;
		this.teacherId = teacherId;
	}

	public UUID getCourseId() {
		return courseId;
	}

	public UUID getTeacherId() {
		return teacherId;
	}


}
