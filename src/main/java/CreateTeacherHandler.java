/**
 * Created by agjendem on 27.05.2014.
 */
public class CreateTeacherHandler implements Handler<CreateTeacherCommand> {

    private final TeacherRepository teacherRepository;

    public CreateTeacherHandler(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void handle(CreateTeacherCommand createTeacherCommand) {
        Teacher teacher = new Teacher(createTeacherCommand.getUuid(), createTeacherCommand.getName());
        this.teacherRepository.add(teacher);
    }
}
