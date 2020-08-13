package recipes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
public class RecipeController {
    private static final Recipe[] recipes = {
            new Recipe(1L, "Pickled Peppers", "TODO ..."),
            new Recipe(2L, "Cold Sesame Soba", "TODO ...")};


    @GetMapping("/recipes")
    public Recipe[] recipes(){
        return this.recipes;
    }


    @GetMapping("/recipes/id/{id}")
    public Recipe recipe(@PathVariable int id) {
        for (Recipe recipe: recipes) {
            if (recipe.getId() == id) {
                return recipe;
            }
        }
        throw new ResponseStatusException (
                HttpStatus.NOT_FOUND, "Recipe not found"
        );
    }


    @GetMapping("/recipies/title/{title}")
    public Recipe recipe(@PathVariable String title) {
        for (Recipe recipe: recipes) {
            if (recipe.getTitle().equals(title)) {
                return recipe;
            }
        }
        throw new ResponseStatusException (
                HttpStatus.NOT_FOUND, "Recipe not found"
        );
    }

}
