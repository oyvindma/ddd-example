package applicationservices.teacher;

import applicationservices.Handles;
import domain.Teacher;
import domain.TeacherRepository;

public class CreateTeacherCommandHandler implements
		Handles<CreateTeacherCommand> {

	private final TeacherRepository teacherRepository;

    // TODO: Could be replaced with injecting the dependencies directly into Handle, using Lambdas
	public CreateTeacherCommandHandler(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	public void handle(CreateTeacherCommand createTeacherCommand) {
		Teacher teacher = new Teacher(
                createTeacherCommand.getTeacherId(),
				createTeacherCommand.getName(),
                createTeacherCommand.getMaxStudents());
		this.teacherRepository.save(teacher);
	}
}
