package src.test;

import src.model.RegularFood;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularFoodTest {

    private RegularFood regularFood;

    @BeforeEach
    public void runBefore() {
        regularFood = new RegularFood("Pizza");
    }

    @Test
    public void testConstructor() {
        assertEquals("Pizza", regularFood.getName());
    }

    @Test
    public void testGetCalorieCount() {
        regularFood.setCalorieCount(500);
        assertEquals(500, regularFood.getCalorieCount()); // assert that the calorie count returned by the method is equal to 500
    }

    @Test
    public void testSetCalorieCount() {
        regularFood.setCalorieCount(500);
        assertEquals(500, regularFood.getCalorieCount());
    }

    @Test
    public void testRegularFoodConstructor() {
        RegularFood regularFood = new RegularFood("Pizza", 500);
        assertEquals("Pizza", regularFood.getName());
//        assertEquals(105, regularFood.RegularFood());
        assertEquals(500, regularFood.getCalorieCount());
    }

    @Test
    public void testToString() {
        RegularFood food = new RegularFood("Apple", 95);
        String expected = "REGULAR_FOOD --> [" +
                "name = Chips" +
                " | calorieCount = 500" +
                ']';

        String actual = food.toString();
        assertEquals(expected, actual);
    }
}
