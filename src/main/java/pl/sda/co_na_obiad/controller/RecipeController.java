package pl.sda.co_na_obiad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.co_na_obiad.model.Ingredients;
import pl.sda.co_na_obiad.model.Recipe;
import pl.sda.co_na_obiad.service.IngredientsService;
import pl.sda.co_na_obiad.service.RecipeService;

import java.util.List;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private IngredientsService ingredientService;

    @GetMapping(path = "/listOfRecipes")
    public String listOfRecipes(Model model){
        List<Recipe> recipeList=recipeService.getAllRecipe();
        model.addAttribute("recipeList", recipeList);
        return "recipeList";
    }
    @GetMapping(path = "/addRecipe")
    public String add(Model model) {
        Recipe recipe = new Recipe();
        List<Ingredients> ingredients = ingredientService.getAllList();
        model.addAttribute("recipe", recipe);
        model.addAttribute("ingredients", ingredients);
        return "addRecipe";
    }

    @PostMapping(path = "/addRecipe")
    public String add(Recipe recipe) {
        recipeService.save(recipe);
        return "redirect:/recipeList";
    }
}
