import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by agjendem on 27.05.2014.
 */
public class WhateverTest {

    @Test
    public void shouldNotThrowExceptionWhenHandlingCreateTeacherCommand() {
        // Given
        CreateTeacherCommand createTeacherCommand = new CreateTeacherCommand(null);
        Handler createTeacherHandler = new CreateTeacherHandler();

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
        TeacherRepository teacherRepositoryMock = ;
        CreateTeacherCommand createTeacherCommand = new CreateTeacherCommand(UUID.randomUUID(), "Felicia Random");
        Handler addTeacherHandler = new CreateTeacherHandler(teacherRepositoryMock);

        // When
        addTeacherHandler.handle(createTeacherCommand);

        // Then
        verify(teacherRepositoryMock).add();
    }
}
