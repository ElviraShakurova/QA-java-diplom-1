import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private float ingredientPrice = 100f;
    private String ingredientName = "hot sauce";

    @Test
    public void testGetPrice(){
        Ingredient ingredient = mock(Ingredient.class);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName(){
        Ingredient ingredient = mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void testGetTypeSauce(){
        Ingredient mockSauce = mock(Ingredient.class);
        Mockito.when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        IngredientType expectedType = IngredientType.SAUCE;
        Ingredient actualIngredient = mockSauce;
        assertEquals(expectedType, actualIngredient.getType());
    }
    @Test
    public void testGetTypeFilling(){
        Ingredient mockFilling = mock(Ingredient.class);
        Mockito.when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        assertEquals(IngredientType.FILLING, mockFilling.getType());
    }
}