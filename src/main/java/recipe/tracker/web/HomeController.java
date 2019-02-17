package recipe.tracker.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;

import recipe.tracker.model.Recipe;
import recipe.tracker.repository.IngredientRepository;

@Controller
public class HomeController {

	@Autowired
	private IngredientRepository ingredients;

	@RequestMapping
	public String index(Model model) {
		model.addAttribute("newRecipe", new Recipe());
		model.addAttribute("allIngredients", ingredients.findAll());
		return "home";
	}
}