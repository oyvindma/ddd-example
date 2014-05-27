import java.util.UUID;


public class Teacher {

	private UUID teacherId;
	private String name;

	public Teacher(UUID teacherId, String name) {
		this.teacherId = teacherId;
		this.name = name;
	}

    public String getName() {
        return name;
    }

    public UUID getTeacherID() {
		return teacherId;
	}

}
