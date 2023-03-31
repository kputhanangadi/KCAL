package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodItemTest {

    private ListManager listManager;

    @BeforeEach
    public void runBefore() {
        listManager = new ListManager();
    }

    @Test
    public void testGetName() {
        FoodItem item = new RegularFood("Banana", 105) {
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
        FoodItem item = new RegularFood("Banana", 105) {
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

//    @Test
//    public void testRemoveManager() throws TooManyCaloriesException {
//        FoodItem item = new RegularFood("Banana", 105);
//        listManager.addNewFood(item);
////        assertEquals(1, listManager.foodCount());
//        item.removeManager();
////        assertEquals(0, listManager.foodCount());
//    }

}