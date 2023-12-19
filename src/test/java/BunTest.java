import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private String bunName = "black bun";
    private float bunPrice = 100f;
    private String emptyBunName = "";
    private String longBunName = "Очень очень преочень длинное длинное предлинное значение";
    private String specialCharactersBunName = "Bun#$5%";
    private float negativeBunPrice = -100f;
    private float zeroBunPrice = 0f;
    private float minimumPositiveBunPrice = 0.001f;
    private float maximumPositiveBunPrice = 999f;

    @Test
    public void testGetName(){
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void testGetPrice(){
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0);
    }

    @Test
    public void testGetEmptyName() {
        Bun bun = new Bun(emptyBunName, bunPrice);
        assertEquals(emptyBunName, bun.getName());
    }

    @Test
    public void testGetLongName() {
        Bun bun = new Bun(longBunName, bunPrice);
        assertEquals(longBunName, bun.getName());
    }

    @Test
    public void testGetNameWithSpecialCharacters() {
        Bun bun = new Bun(specialCharactersBunName, bunPrice);
        assertEquals(specialCharactersBunName, bun.getName());
    }

    @Test
    public void testGetNegativePrice() {
        Bun bun = new Bun(bunName, negativeBunPrice);
        assertEquals(negativeBunPrice, bun.getPrice(), 0);
    }

    @Test
    public void testGetPriceReturnZero() {
        Bun bun = new Bun(bunName, zeroBunPrice);
        assertEquals(zeroBunPrice, bun.getPrice(), 0);
    }

    @Test
    public void testGetPriceReturnsMinimumPositiveValue() {
        Bun bun = new Bun(bunName, minimumPositiveBunPrice);
        assertEquals(minimumPositiveBunPrice, bun.getPrice(), 0);
    }

    @Test
    public void testGetPriceReturnsMaximumPositiveValue() {
        Bun bun = new Bun(bunName, maximumPositiveBunPrice);
        assertEquals(maximumPositiveBunPrice, bun.getPrice(), 0);
    }
}