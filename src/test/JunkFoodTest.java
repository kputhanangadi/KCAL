package src.test;

import src.model.JunkFood;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class JunkFoodTest {

    @Test
    public void testJunkFoodConstructor() {
        JunkFood food = new JunkFood("Chocolate Bar", 1, 230);
        assertEquals("Chocolate Bar", food.getName());
        assertEquals(1, food.getType());
        assertEquals(230, food.getCalorieCount());
    }

    @Test
    public void testGetCalorieCount() {
        JunkFood food = new JunkFood("Chocolate Bar", 1, 230);
        assertEquals(230, food.getCalorieCount());
    }

    @Test
    public void testToString() {
        JunkFood junkFood = new JunkFood("Chips", 500, 20);
        String expectedString = "JUNK_FOOD --> [" +
                "name = Chips" +
                " | calorieCount = 500" +
                " | sugarCount = 20" +
                ']';

        String actualString = junkFood.toString();
        assertEquals(expectedString, actualString);
    }
}