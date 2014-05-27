import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by agjendem on 27.05.2014.
 */
public class WhateverTest {

    @Test
    public void shouldNotThrowExceptionWhenHandlingCreateTeacherCommand() {
        // Given
        CreateTeacherCommand createTeacherCommand = new CreateTeacherCommand(null, "No Name");
        TeacherRepository teacherRepositoryMock = mock(TeacherRepository.class);
        Handler<CreateTeacherCommand> createTeacherHandler = new CreateTeacherHandler(teacherRepositoryMock);

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
        Handler<CreateTeacherCommand> addTeacherHandler = new CreateTeacherHandler(teacherRepositoryMock);

        // When
        addTeacherHandler.handle(createTeacherCommand);

        // Then
        ArgumentCaptor<Teacher> teacherArgument = ArgumentCaptor.forClass(Teacher.class);
        verify(teacherRepositoryMock).add(teacherArgument.capture());
        assertEquals("Felicia Random", teacherArgument.getValue().getName());
    }
}
