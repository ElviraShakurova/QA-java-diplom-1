import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerTest {
    @Mock
    private Bun bun;


    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;

    private Burger burger;

    private List<Ingredient> ingredients;

    public BurgerTest(Bun bun, List<Ingredient> ingredients) {
        this.bun = bun;
        this.ingredients = ingredients;
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        when(bun.getName()).thenReturn("test bun");
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("test sauce");
        when(ingredient1.getPrice()).thenReturn(50f);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("test filling");
        when(ingredient2.getPrice()).thenReturn(200f);
        when(ingredient3.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient3.getName()).thenReturn("test sauce 2");
        when(ingredient3.getPrice()).thenReturn(75f);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new Bun("black bun", 100), Arrays.asList(
                        new Ingredient(IngredientType.SAUCE,"hot sauce", 100),
                        new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                        new Ingredient(IngredientType.FILLING,"cutlet", 100 )
                )},
                {new Bun("white bun", 200), Arrays.asList(
                        new Ingredient(IngredientType.SAUCE,  "chili sauce", 300),
                        new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                        new Ingredient(IngredientType.FILLING, "sausage", 300)
                )},
                {new Bun("red bun", 300), Arrays.asList(
                        new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                        new Ingredient(IngredientType.FILLING, "cutlet", 100),
                        new Ingredient(IngredientType.FILLING, "sausage", 300)
                )},
        });
    }

    @Test
    public void testSetBuns(){
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient(){
        Ingredient ingredient = ingredients.get(0);
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient(){
        for (Ingredient ingredient : ingredients){
            burger.addIngredient(ingredient);
        }
        int indexRemove = ingredients.size() - 1;
        Ingredient ingredientRemove = ingredients.get(indexRemove);
        burger.removeIngredient(indexRemove);
        assertEquals(ingredients.size() - 1, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(ingredientRemove));
    }

    @Test
    public void testMoveIngredient(){
        for (Ingredient ingredient : ingredients){
            burger.addIngredient(ingredient);
        }
        int indexMove = 0;
        int newIndex = 1;
        Ingredient ingredientMove = ingredients.get(indexMove);
        burger.moveIngredient(indexMove, newIndex);
        assertEquals(ingredientMove, burger.ingredients.get(newIndex));
    }

    @Test
    public void testGetPrice(){
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients){
            burger.addIngredient(ingredient);
        }
        float expectedPrice = bun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            expectedPrice += ingredient.getPrice();
        }

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt(){
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients){
            burger.addIngredient(ingredient);
        }
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            expectedReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        expectedReceipt.append(String.format("(==== %s ====)%n", bun.getName()));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}