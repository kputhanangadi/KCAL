package test;

import model.FoodItem;
import model.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListManagerTest {

    private ListManager listManager;

    @BeforeEach
    public void runBefore() {
        listManager = new ListManager();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, listManager.foodCount());
    }

    @Test
    public void addNewFoodTest() {
        listManager.addNewFood("Chips");
        assertEquals(1, listManager.foodCount());
    }

    @Test
    public void deleteFoodIndexOnceTest() {
        listManager.addNewFood("Chips");
        assertEquals(1, listManager.foodCount());
        listManager.deleteFoodIndex(0);
        assertEquals(0, listManager.foodCount());
    }

    @Test
    public void deleteFoodIndexEmptyTest() {
        listManager.deleteFoodIndex(0);
        assertEquals(0, listManager.foodCount());
    }

//    @Test
//    public void showFoodItemsNotEmptyTest() {
//        listManager.addNewFood("Chips");
//        assertEquals(1, listManager.foodCount());
//        listManager.showFoodItems();
//        assertEquals(1, listManager.foodCount());
//    }

    @Test
    public void showFoodItemsEmptyTest() {
        listManager.showFoodItems();
        assertEquals(0, listManager.foodCount());
    }

//    @Test
//    public void foodCountNotEmptyTest() {
//        listManager.addNewFood("Chips");
//        assertEquals(1, listManager.foodCount());
//    }

    @Test
    public void foodCountEmptyTest() {
        assertEquals(0, listManager.foodCount());
    }

    @Test
    public void saveTest() {

    }

    @Test
    public void loadTest() {

    }

    @Test
    public void testGetFoodItemsOutput() {
        String expectedOutput = "Eat some food to log!\n";

        // Test with an empty foodItemList
        String actualOutput = listManager.getFoodItemsOutput();
        assertEquals(expectedOutput, actualOutput);

        // Test with a non-empty foodItemList
        listManager.addNewFood(String.valueOf(new FoodItem("Banana", 105) {
            @Override
            public int getCalorieCount() {
                return 0;
            }
        }));
        listManager.addNewFood(String.valueOf(new FoodItem("Apple", 105) {
            @Override
            public int getCalorieCount() {
                return 0;
            }
        }));
        expectedOutput = "Food Consumed: \n[1] - FoodItem [name =Banana]\n[2] - FoodItem [name =Apple]\n--------------------------------------------------\n";
        actualOutput = listManager.getFoodItemsOutput();
        assertEquals(expectedOutput, actualOutput);
    }

//    @Test
//    public void testGetTotalCaloriesConsumed() {
//        int expectedCalories = 0;
//
//        // Test with an empty foodItemList
//        int actualCalories = listManager.getTotalCaloriesConsumed();
//        assertEquals(expectedCalories, actualCalories);
//
//        // Test with a non-empty foodItemList
//        listManager.addNewFood(String.valueOf(new FoodItem("Banana", 105) {
//            @Override
//            public int getCalorieCount() {
//                return 105;
//            }
//        }));
//        listManager.addNewFood(String.valueOf(new FoodItem("Apple", 95) {
//            @Override
//            public int getCalorieCount() {
//                return 95;
//            }
//        }));
//        expectedCalories = 200;
//        actualCalories = listManager.getTotalCaloriesConsumed();
//        assertEquals(expectedCalories, actualCalories);
//    }
}
