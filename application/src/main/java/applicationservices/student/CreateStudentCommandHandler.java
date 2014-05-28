package applicationservices.student;

import integrationservices.InMemoryStudentRepository;
import applicationservices.Handles;
import domain.Student;

public class CreateStudentCommandHandler implements
		Handles<CreateStudentCommand> {

	private InMemoryStudentRepository inMemoryStudentRepository;

	public CreateStudentCommandHandler(InMemoryStudentRepository inMemoryStudentRepository) {
		this.inMemoryStudentRepository = inMemoryStudentRepository;
	}

	public void handle(CreateStudentCommand command) {
		inMemoryStudentRepository.save(new Student(command.getStudentId(),
				command.getCouseName()));
	}

}
