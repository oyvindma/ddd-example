import java.util.UUID;

/**
 * Created by agjendem on 27.05.2014.
 */
public class CreateTeacherCommand { // Message

    private final UUID uuid;
    private final String name;

    public CreateTeacherCommand(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
