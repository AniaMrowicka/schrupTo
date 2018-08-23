package pl.sda.co_na_obiad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.co_na_obiad.model.Recipe;
import pl.sda.co_na_obiad.service.RecipeService;

import java.util.List;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(path = "/listOfRecipes")
    public String listOfRecipes(Model model){
        List<Recipe> recipeList=recipeService.getAllRecipe();
        model.addAttribute("recipeList", recipeList);
        return "recipeList";
    }
}
