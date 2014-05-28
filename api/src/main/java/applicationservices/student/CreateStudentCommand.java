package applicationservices.student;

import java.util.UUID;

public class CreateStudentCommand {

	private UUID studentId;
	private String studentName;

	public CreateStudentCommand(UUID studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public UUID getStudentId() {
		return studentId;
	}

	public String getCouseName() {
		return studentName;
	}


}
