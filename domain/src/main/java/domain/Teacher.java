package domain;
import java.util.UUID;


public class Teacher {

	private UUID teacherId;
	private String name;
    private int maxStudents;

	public Teacher(UUID teacherId, String name, int maxStudents) {
		this.teacherId = teacherId;
		this.name = name;
        this.maxStudents = maxStudents;
	}

    public String getName() {
        return name;
    }

    public UUID getTeacherID() {
		return teacherId;
	}

    public int getMaxStudents() {
        return maxStudents;
    }
}
