package finalproject.GymApp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

	//List<Exercise> findById(Long id);
	List<Exercise> findByName (String string);
}
