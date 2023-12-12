import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BunTest {

    @Test
    public void testGetName(){
        Bun bun = new Bun("black bun", 100f);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice(){
        Bun bun = new Bun("black bun", 100f);
        assertEquals(100f, bun.getPrice(), 0);
    }

    @Test
    public void testGetEmptyName() {
        Bun bun = new Bun("", 100f);
        assertEquals("", bun.getName());
    }

    @Test
    public void testGetLongName() {
        Bun bun = new Bun("Очень очень преочень длинное длинное предлинное значение", 100f);
        assertEquals("Очень очень преочень длинное длинное предлинное значение", bun.getName());
    }

    @Test
    public void testGetNameWithSpecialCharacters() {
        Bun bun = new Bun("Bun#$5%", 100f);
        assertEquals("Bun#$5%", bun.getName());
    }

    @Test
    public void testGetNegativePrice() {
        Bun bun = new Bun("black bun", -100f);
        assertEquals(-100f, bun.getPrice(), 0);
    }

    @Test
    public void testGetPriceReturnZero() {
        Bun bun = new Bun("black bun", 0f);
        assertEquals(0, bun.getPrice(), 0);
    }

    @Test
    public void testGetPriceReturnsMinimumPositiveValue() {
        Bun bun = new Bun("black bun", 0.001f);
        assertEquals(0.001f, bun.getPrice(), 0);
    }

    @Test
    public void testGetPriceReturnsMaximumPositiveValue() {
        Bun bun = new Bun("black bun", 999f);
        assertEquals(999f, bun.getPrice(), 0);
    }
}