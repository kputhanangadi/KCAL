package test;

import model.FoodItem;
import model.JunkFood;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodItemTest {

    @Test
    public void testGetName() {
        FoodItem item = new FoodItem("Banana", 105) {
            @Override
            public int getCalorieCount() {
                return 0;
            }
        };
        String expected = "Banana";
        assertEquals(expected, item.getName());
    }

    @Test
    public void testGetCalorieCount() {
        FoodItem item = new FoodItem("Banana", 105) {
            @Override
            public int getCalorieCount() {
                return 0;
            }
        };
        int expected = 0;
        assertEquals(expected, item.getCalorieCount());
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