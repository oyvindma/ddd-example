package domain;

import java.util.UUID;

public class Student {

	private UUID studentId;
	private String studentName;

	public Student(UUID studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public UUID getStudentId() {
		return studentId;
	}

}
