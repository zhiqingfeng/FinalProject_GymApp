package finalproject.GymApp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;


import finalproject.GymApp.domain.CategoryRepository;
import finalproject.GymApp.domain.Exercise;
import finalproject.GymApp.domain.ExerciseRepository;
import finalproject.GymApp.domain.Category;

@SpringBootTest(classes = GymAppApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ExerciseRepositoryTest {


	@Autowired
	private ExerciseRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Test //search
	public void findByNameShouldReturnExercise() {
		List<Exercise> exercises = repository.findByName("Pilates 45");
		assertThat(exercises).hasSize(1);
		assertThat(exercises.get(0).getTeacher()).isEqualTo("Tiina");
	}
	
	@Test //create
	public void createNewExercise() {
		Category category = new Category("Test");
		crepository.save(category);
		Exercise exercise = new Exercise("X-CROSS Basic 60", "This is the online fitness and you can workout anytime and anywhere", 
				"60 min", "18:00 -19:00", "Monday", "Heidi", category);
		repository.save(exercise);
		assertThat(exercise.getId()).isNotNull();
	}
	
	@Test //delete
	public void deleteNewExercise() {
		List<Exercise> exercises = repository.findByName("HITBody");
		Exercise exercise = exercises.get(0);
		repository.delete(exercise);
		List<Exercise> newExercises = repository.findByName("HITBody");
		assertThat(newExercises).hasSize(0);
	}
}
