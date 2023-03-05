package src.test;

import src.model.FoodItem;
import src.model.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    public void testShowFoodItemsEmpty() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        listManager.showFoodItems();
        assertEquals("Eat some food to log!\n\n", outputStream.toString());
    }

//    @Test
//    public void testShowFoodItemsNonEmpty() {
//        FoodItem apple = new RegularFood("Apple", 50);
//        FoodItem pizza = new RegularFood("Pizza", 500);
//        FoodItem soda = new RegularFood("Soda", 200);
//
//        listManager.addNewFood(String.valueOf(apple));
//        listManager.addNewFood(String.valueOf(pizza));
//        listManager.addNewFood(String.valueOf(soda));
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        listManager.showFoodItems();
//
//        assertEquals("Food Consumed: \n[1] - Apple\n[2] - Pizza\n[3] - Soda\n\n", outputStream.toString());
//    }
//
//    @Test
//    public void testGetTotalCaloriesConsumed() {
//        FoodItem apple = new RegularFood("Apple", 50);
//        FoodItem pizza = new RegularFood("Pizza", 500);
//        FoodItem soda = new RegularFood("Soda", 200);
//
//        listManager.addNewFood(String.valueOf(apple));
//        listManager.addNewFood(String.valueOf(pizza));
//        listManager.addNewFood(String.valueOf(soda));
//
//        assertEquals(750, listManager.getTotalCaloriesConsumed());
//    }
}

