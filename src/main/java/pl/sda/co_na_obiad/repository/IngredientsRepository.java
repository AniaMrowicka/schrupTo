package pl.sda.co_na_obiad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.co_na_obiad.model.Ingredients;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
}
