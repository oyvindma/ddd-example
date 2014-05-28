package applicationservices.course;

import domain.Course;
import domain.CourseRepository;
import domain.Teacher;
import domain.TeacherRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AssignTeacherToCourseCommandHandlerTest {

	@Test
	public void shouldAssignTeacherToCourse() {
		// Given
		CourseRepository courseRepository = mock(CourseRepository.class);
        TeacherRepository teacherRepository = mock(TeacherRepository.class);

        UUID teacherId = UUID.randomUUID();
        UUID courseId = UUID.randomUUID();
        Course course = new Course(courseId, "Course from mock");
        Teacher teacher = new Teacher(teacherId, "Teacher from mock", 42);

        when(courseRepository.get(courseId)).thenReturn(course);
        when(teacherRepository.get(teacherId)).thenReturn(teacher);

        AssignTeacherToCourseCommandHandler assignTeacherToCourseCommandHandler =
                new AssignTeacherToCourseCommandHandler(courseRepository, teacherRepository);

		// When
		assignTeacherToCourseCommandHandler.handle(new AssignTeacherToCourseCommand(courseId, teacherId));

		// Then
        ArgumentCaptor<Course> courseArgument = ArgumentCaptor.forClass(Course.class);
        verify(courseRepository).save(courseArgument.capture());

        assertEquals(course, courseArgument.getValue());
        assertTrue(courseArgument.getValue().isAssigned(teacher));
        assertFalse(courseArgument.getValue().isAssigned(new Teacher(UUID.randomUUID(), "Not assigned", 1)));
	}

}
