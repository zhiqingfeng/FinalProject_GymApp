package finalproject.GymApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import finalproject.GymApp.web.ExerciseController;

@SpringBootTest
class GymAppApplicationTests {

	@Autowired
	private ExerciseController controller;
	@Test
	void contextLoads() {
	}

}
