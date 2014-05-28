package applicationservices.student;

import applicationservices.student.CreateStudentCommand;
import applicationservices.student.CreateStudentCommandHandler;
import integrationservices.InMemoryStudentRepository;

import java.util.UUID;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class CreateStudentCommandHandlerTest {

	@Test
	public void shouldNotThrowExceptionWhenHandlingCreateStudentCommand() {
		// Given
		CreateStudentCommand createStudentCommand = new CreateStudentCommand(UUID.randomUUID(),
				"Student name");
		CreateStudentCommandHandler createStudentCommandHandler = new CreateStudentCommandHandler(
				new InMemoryStudentRepository());

		// When
		createStudentCommandHandler.handle(createStudentCommand);
	}

	@Test
	public void shouldPersistStudent() {
		// Given
		InMemoryStudentRepository studentRepository = new InMemoryStudentRepository();
		CreateStudentCommandHandler commandHandler = new CreateStudentCommandHandler(studentRepository);

		// When
		UUID studentId = UUID.randomUUID();
		CreateStudentCommand createStudentCommand = new CreateStudentCommand(studentId,
				"Student name");
		commandHandler.handle(createStudentCommand);

		// Then
		Assertions.assertThat(studentRepository.get(studentId)).isNotNull();
	}

}
