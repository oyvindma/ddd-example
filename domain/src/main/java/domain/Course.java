package domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Course {

	private UUID courseId;
	private String courseName;
    private int maxStudents;

    // Track assigned teachers, but these are used at repo-level in our relational model
    private Set<UUID> teacherIds = new HashSet<UUID>();

	public Course(UUID courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
        this.maxStudents = -1;
	}

	public UUID getCourseId() {
		return courseId;
	}

    public void assignTeacher(Teacher teacher) {
        if (this.maxStudents == -1) {
            this.maxStudents = teacher.getMaxStudents();
        }
        this.teacherIds.add(teacher.getTeacherID());
    }

    public boolean isAssigned(Teacher teacher) {
        return this.teacherIds.contains(teacher.getTeacherID());
    }

	public boolean isHeldByTeacher(UUID teacherId) {
		return teacherIds.contains(teacherId);
	}
}
