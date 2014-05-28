package teacher;
import applicationservices.Handles;
import applicationservices.teacher.CreateTeacherCommandHandler;
import applicationservices.teacher.CreateTeacherCommand;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import domain.Teacher;
import domain.TeacherRepository;

import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by agjendem on 27.05.2014.
 */
public class CreateTeacherCommandHandlerTest {

    @Test
    public void shouldNotThrowExceptionWhenHandlingCreateTeacherCommand() {
        // Given
        CreateTeacherCommand createTeacherCommand = new CreateTeacherCommand(null, "No Name");
        TeacherRepository teacherRepositoryMock = mock(TeacherRepository.class);
        Handles<CreateTeacherCommand> createTeacherHandler = new CreateTeacherCommandHandler(teacherRepositoryMock);

        try {
            // When
            createTeacherHandler.handle(createTeacherCommand);
        } catch (Exception e) {
            // Then
            Assert.fail("Shouldn't happen: " + e.getMessage());
        }
    }

    @Test
    public void shouldCreateTeacherWhenHandlingCreateTeacherCommand() {
        // Given
        CreateTeacherCommand createTeacherCommand = new CreateTeacherCommand(UUID.randomUUID(), "Felicia Random");
        TeacherRepository teacherRepositoryMock = mock(TeacherRepository.class);
        Handles<CreateTeacherCommand> addTeacherHandler = new CreateTeacherCommandHandler(teacherRepositoryMock);

        // When
        addTeacherHandler.handle(createTeacherCommand);

        // Then
        ArgumentCaptor<Teacher> teacherArgument = ArgumentCaptor.forClass(Teacher.class);
        verify(teacherRepositoryMock).add(teacherArgument.capture());
        assertEquals("Felicia Random", teacherArgument.getValue().getName());
    }
}
