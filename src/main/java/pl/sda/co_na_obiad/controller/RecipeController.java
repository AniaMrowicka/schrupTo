package pl.sda.co_na_obiad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.sda.co_na_obiad.model.Ingredients;
import pl.sda.co_na_obiad.model.Recipe;
import pl.sda.co_na_obiad.service.IngredientsService;
import pl.sda.co_na_obiad.service.RecipeService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

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
        model.addAttribute("images", recipeList.stream().map(item -> {
            if(item.getImage().length == 0){
                return "";
            }else{
                return new String(Base64.getEncoder().encode(item.getImage()));
            }
        }).collect(Collectors.toList()));
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
    public String add(Recipe recipe, @RequestParam("photo") MultipartFile file) {
        String name = file.getName();
        try {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
            stream.write(bytes);
            stream.close();
            recipe.setImage(bytes);
        } catch (Exception e) {
            System.out.println("File has not been added.");
        }
        recipeService.save(recipe);
        return "redirect:/listOfRecipes";
    }


}
