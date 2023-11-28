package finalproject.GymApp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import finalproject.GymApp.domain.CategoryRepository;
import finalproject.GymApp.domain.ExerciseRepository;
import finalproject.GymApp.domain.Exercise;

@Controller
public class ExerciseController {

	@Autowired
	private ExerciseRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	//Login
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}

	// List all the exercises
	@RequestMapping(value="/exerciselist")
	public String exerciseList(Model model) {
		model.addAttribute("exercises", repository.findAll());
		return "exerciselist";
	}
	
	//RESTful service to get all exercises
	@RequestMapping(value="/exercises", method = RequestMethod.GET)
	public @ResponseBody List<Exercise> exerciseRest(){
		return (List<Exercise>) repository.findAll();
	}
	//RESTful service to get exercise by id
	@RequestMapping(value = "/exercise/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Exercise> findExerciseRest(@PathVariable("id") Long exerciseId){
		return repository.findById(exerciseId);
	}
	
	// Add a new exercise
	@RequestMapping(value="/addexercise")
	public String addExercise(Model model) {
		model.addAttribute("exercise", new Exercise());
		model.addAttribute("categorys", crepository.findAll());
		return "addexercise";
	}
	
	// Save a new exercise
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Exercise exercise) {
		repository.save(exercise);
		return "redirect:exerciselist";
	}
	// Delete the exercise
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteExercise(@PathVariable("id")Long exerciseId, Model model) {
		repository.deleteById(exerciseId);
		return "redirect:../exerciselist";
	}
	
	// Edit the exercise
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/editexercise/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("exercise", repository.findById(id).get());
		model.addAttribute("categorys", crepository.findAll()); // this is for dropdown
		return "editexercise";
	}
	
	@PostMapping("/update/{id}")
	public String updateExercise(Exercise exercise) {
		repository.save(exercise);
		return "redirect:/exerciselist";
	}
	
	
}