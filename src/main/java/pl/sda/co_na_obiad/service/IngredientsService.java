package pl.sda.co_na_obiad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.co_na_obiad.model.Ingredients;
import pl.sda.co_na_obiad.repository.IngredientsRepository;

import java.util.List;

@Service
public class IngredientsService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public List<Ingredients> getAllList() {
    return ingredientsRepository.findAll();
    }
}
