package test;

import model.FoodItem;
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
        FoodItem item = new FoodItem("Banana", 105) {
            @Override
            public int getCalorieCount() {
                return 0;
            }
        };
        String expected = "FoodItem [name =Banana]";
        assertEquals(expected, item.toString());
    }
}