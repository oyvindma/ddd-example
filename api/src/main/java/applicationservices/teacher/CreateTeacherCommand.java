package applicationservices.teacher;

import java.util.UUID;
 
// TODO: Could be generated from a Google Protocol Buffer file (.proto) - which we share as our schema with the client(s)
public class CreateTeacherCommand { // Message

    private final UUID teacherId;
    private final String name;
    private final int maxStudents;

    public CreateTeacherCommand(UUID teacherId, String name, int maxStudents) {
        this.teacherId = teacherId;
        this.name = name;
        this.maxStudents = maxStudents;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }
}
