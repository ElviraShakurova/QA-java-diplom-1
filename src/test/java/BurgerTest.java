import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;

    private Burger burger;
    private List<Ingredient> ingredients;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
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

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = ingredients.get(0);
        burger.addIngredient(ingredient);
        int expectedSize = 1;
        assertEquals(expectedSize, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        int indexToRemove = ingredients.size() - 1;
        Ingredient ingredientToRemove = ingredients.get(indexToRemove);
        burger.removeIngredient(indexToRemove);
        assertEquals(ingredients.size() - 1, burger.ingredients.size());
        assertFalse(burger.ingredients.contains(ingredientToRemove));
    }

    @Test
    public void testMoveIngredient() {
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        int indexToMove = 0;
        int newIndex = 1;
        Ingredient ingredientToMove = ingredients.get(indexToMove);
        burger.moveIngredient(indexToMove, newIndex);
        assertEquals(ingredientToMove, burger.ingredients.get(newIndex));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        float expectedPrice = bun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            expectedPrice += ingredient.getPrice();
        }

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
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