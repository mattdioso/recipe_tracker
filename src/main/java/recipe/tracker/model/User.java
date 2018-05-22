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

import recipe.tracker.model.Recipe;

import java.util.List;

@Entity
public class User extends BaseObject {

	@Column(name = "userName", nullable=false)
	private String userName;

	@Column(name = "userEmail", nullable=false)
	private String userEmail;

	@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
	@OrderColumn(name="recipeName")
	private List<Recipe> recipes;

	public User() {}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserEmail(String email) {
		this.userEmail = email;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}
}