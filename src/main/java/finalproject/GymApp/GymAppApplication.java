package finalproject.GymApp;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import finalproject.GymApp.domain.CategoryRepository;
import finalproject.GymApp.domain.ExerciseRepository;
import finalproject.GymApp.domain.*;

@SpringBootApplication
public class GymAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymAppApplication.class, args);
	}
	@Bean
	public CommandLineRunner GymApp(ExerciseRepository repository, CategoryRepository crepository, AppUserRepository urepository) {
		return(args) -> {
			crepository.save(new Category("Cardio"));
			crepository.save(new Category("Body&Mind"));
			crepository.save(new Category("Spinning"));
			crepository.save(new Category("Dance"));
			
			repository.save(new Exercise("Yin&Yang Yoga",
					"Yoga develops stamina, body coordination, balance, mobility and strength. During the class, you will do basic chants to the rhythm of your breath, according to your own feelings. The level of intensity is determined by the individual and is therefore suitable for everyone.",
					"60min", "19:20 - 20:20", "Monday", "Ninni", crepository.findByName("Body&Mind").get(0)));
			repository.save(new Exercise("Pilates 45","In Pilates you can challenge your core, strengthen the deep muscles of your body and improve posture. Pilates will help you maintain your body and release tension in your body. The easy and effective breathing movements are suitable for fitness enthusiasts of all levels.",
					"45min", "18:00 - 18:45","Monday", "Tiina", crepository.findByName("Body&Mind").get(0)));
			repository.save(new Exercise("HITBody", "HIIT, or High Intensity Interval Training, is a high-intensity interval workout that is effective in burning fat after a workout and quickly increasing aerobic fitness. You adjust the intensity of the workout during the class according to your fitness level.",
					"30min", "18:00 - 18:30", "Wednesday & Thursday", "Jukka", crepository.findByName("Cardio").get(0)));
			repository.save(new Exercise("Indoor Bicycle", "Indoor cycling is a fun, effective and safe form of endurance training. Suitable for both beginners and more experienced cyclists. At the beginning of the class, you will learn how to adjust your bike.",
					"60min", "18:00 - 19:00", "Tuesday & Friday", "Eero", crepository.findByName("Spinning").get(0)));
			repository.save(new Exercise("JUST DANCE", "Just Dance is a motion-based dance , with each music including a collection of classic and modern songs each with its own dance choreographies.",
					"60min", "19:00 - 20:00", "Wednesday & Thursday", "Joanna", crepository.findByName("Dance").get(0)));
			
			//Create users: admin/admin, user/user
			AppUser user1 = new AppUser("user", "$2a$12$IoRr5U1RZsUNG1KWOG45JuAB2j01qED2VUWgN0iSEnFwdl4g3Zfxa","user@gymapp.com", "USER");
			AppUser user2 = new AppUser("admin", "$2a$12$AsFYw8o1KmNZw4KQlZGZruXleQ3xHw7Co1/MCJ/H.MQiK1.iCFUMK", "admin@gymapp.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			System.out.println("IN COMMAND LINE RUNNER");
			
			for(Exercise exercise : repository.findAll()) {
				System.out.println(exercise.toString());
			}
		};
	}

}
