package recipe.tracker.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import recipe.tracker.model.Ingredient;

public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, String> {
	public Ingredient findByIngredientName(String name);
}