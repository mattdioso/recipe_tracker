package recipe.tracker.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import recipe.tracker.model.Recipe;
import recipe.tracker.model.User;

public interface RecipeRepository extends PagingAndSortingRepository<Recipe, String> {
	public Recipe findByRecipeName(String name);
	public List<Recipe> findAllByUserID(String id);
	public List<Recipe> findAllByUser(User user);
}