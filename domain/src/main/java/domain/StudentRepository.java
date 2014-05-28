package domain;

import java.util.UUID;

public interface StudentRepository {
	void save(Student student);

	Student get(UUID studentId);

}
