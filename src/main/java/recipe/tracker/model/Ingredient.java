package recipe.tracker.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

import recipe.tracker.model.Recipe;

@Entity
public class Ingredient extends BaseObject {

	@Column(name = "name", nullable = false)
	private String ingredientName;

	@ManyToOne
	private Recipe recipe;

	@Lob
	private String description;

	public Ingredient() {}

	public void setIngredientName(String name) {
		this.ingredientName = name;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}