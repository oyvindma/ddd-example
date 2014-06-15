package applicationservices.course;

import static org.fest.assertions.Assertions.assertThat;
import integrationservices.InMemoryCourseRepository;
import integrationservices.InMemoryTeacherRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;

import applicationservices.Queries;
import domain.Course;
import domain.CourseRepository;
import domain.Teacher;
import domain.TeacherRepository;


public class FindCoursesTaughtByTeacherQueryHandlerTest {

	private AssignTeacherToCourseCommandHandler assignTeacherToCourseCommandHandler;

	@Test
	public void shouldReturnListOfCoursesTaughtByTeacher() throws Exception {
		CourseRepository courseRepository = new InMemoryCourseRepository();
		TeacherRepository teacherRepository = new InMemoryTeacherRepository();
		
		UUID teacherId = persistNewTeacher(teacherRepository);
		UUID course1Id = persistNewCourse(courseRepository);
		UUID course2Id = persistNewCourse(courseRepository);
		
		UUID teacherId2 = persistNewTeacher(teacherRepository);
		UUID courseNotToBeFound = persistNewCourse(courseRepository);
		
		assignTeacherToCourseCommandHandler = new AssignTeacherToCourseCommandHandler(courseRepository,teacherRepository);
		assignTeacherToCourseCommandHandler.handle(new AssignTeacherToCourseCommand(course1Id, teacherId));
		assignTeacherToCourseCommandHandler.handle(new AssignTeacherToCourseCommand(course2Id, teacherId));
		assignTeacherToCourseCommandHandler.handle(new AssignTeacherToCourseCommand(courseNotToBeFound, teacherId2));
		
		Queries<FindCoursesTaughtByTeacherQuery,Set<UUID>> findTeachersHandler = new FindCoursesTaughtByTeacherQueryHandler(courseRepository);
		Set<UUID> courseList = findTeachersHandler.query(new FindCoursesTaughtByTeacherQuery(teacherId));
		assertThat(courseList)
			.hasSize(2)
			.containsOnly(course1Id, course2Id);

	}

	private UUID persistNewTeacher(TeacherRepository teacherRepository) {
		UUID randomUUID = UUID.randomUUID();
		teacherRepository.save(new Teacher(randomUUID, "Test teacher", 5));
		return randomUUID;
	}
	
	private UUID persistNewCourse(CourseRepository teacherRepository) {
		UUID randomUUID = UUID.randomUUID();
		teacherRepository.save(new Course(randomUUID, "Test Course"));
		return randomUUID;
	}
	
	
}
