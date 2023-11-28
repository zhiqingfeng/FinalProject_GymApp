package finalproject.GymApp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	//List<Exercise> findById(Long id);
	List<Category> findByName(String name);
}
