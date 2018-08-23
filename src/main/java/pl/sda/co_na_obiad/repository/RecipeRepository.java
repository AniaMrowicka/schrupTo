package pl.sda.co_na_obiad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.co_na_obiad.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
