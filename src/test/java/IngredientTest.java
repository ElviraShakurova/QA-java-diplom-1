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
    @Test
    public void testGetPrice(){
        Ingredient ingredient = mock(Ingredient.class);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        assertEquals(100f, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName(){
        Ingredient ingredient = mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        assertEquals("hot sauce", ingredient.getName());
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
        IngredientType expectedType = IngredientType.FILLING;
        Ingredient actualIngredient = mockFilling;
        assertEquals(expectedType, actualIngredient.getType());
    }
}
