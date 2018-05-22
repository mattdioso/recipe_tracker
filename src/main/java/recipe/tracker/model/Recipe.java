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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

import recipe.tracker.model.Ingredient;
import recipe.tracker.model.User;

import java.util.HashMap;

@Entity
public class Recipe extends BaseObject {

	@Column(name="recipeName", nullable=false)
	private String recipeName;

	@Column(name = "userID", nullable = false)
	private String userID;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "recipe", cascade = {CascadeType.ALL})
	@OrderBy("recipe")
	private HashMap<Ingredient, Integer> ingredients;

	public Recipe() {}

	public void setRecipeName(String name) {
		this.recipeName = name;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUser(User user)  {
		this.user=user;
	}

	public User getUser() {
		return user;
	}

	public void setIngredients(HashMap<Ingredient, Integer> ingredients) {
		this.ingredients = ingredients;
	}

	public HashMap<Ingredient, Integer> getIngredients() {
		return ingredients;
	}
}