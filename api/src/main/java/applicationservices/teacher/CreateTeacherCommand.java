package applicationservices.teacher;

import java.util.UUID;
 
// TODO: Could be generated from a Google Protocol Buffer file (.proto) - which we share as our schema with the client(s)
public class CreateTeacherCommand { // Message

    private final UUID teacherId;
    private final String name;

    public CreateTeacherCommand(UUID teacherId, String name) {
        this.teacherId = teacherId;
        this.name = name;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }
}
