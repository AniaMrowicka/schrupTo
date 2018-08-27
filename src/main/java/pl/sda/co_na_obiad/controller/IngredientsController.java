package pl.sda.co_na_obiad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.co_na_obiad.model.Ingredients;
import pl.sda.co_na_obiad.service.IngredientsService;

import java.util.List;
@Controller
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping(path = "/ingredientsList")
    public String list(Model model){
        List<Ingredients> ingredientsList = ingredientsService.getAllList();
        model.addAttribute("ingredientsList", ingredientsList);
        return "ingredientsList";
    }


}
