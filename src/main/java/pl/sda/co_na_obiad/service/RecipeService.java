package pl.sda.co_na_obiad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.co_na_obiad.model.Recipe;
import pl.sda.co_na_obiad.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipe (){
        return recipeRepository.findAll();
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
