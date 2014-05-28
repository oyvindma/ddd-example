package applicationservices.teacher;

import java.util.UUID;
 
/**
 * Created by agjendem on 27.05.2014.
 */
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
