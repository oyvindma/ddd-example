package applicationservices.teacher;

import applicationservices.Handles;
import domain.Teacher;
import domain.TeacherRepository;

/**
 * Created by agjendem on 27.05.2014.
 */
public class CreateTeacherCommandHandler implements
		Handles<CreateTeacherCommand> {

	private final TeacherRepository teacherRepository;

	public CreateTeacherCommandHandler(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	public void handle(CreateTeacherCommand createTeacherCommand) {
		Teacher teacher = new Teacher(createTeacherCommand.getTeacherId(),
				createTeacherCommand.getName());
		this.teacherRepository.add(teacher);
	}
}