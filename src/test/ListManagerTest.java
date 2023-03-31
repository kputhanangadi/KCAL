package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.model.FoodItem;
import src.model.ListManager;
import src.model.RegularFood;
import src.model.TooManyCaloriesException;

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
    public void addNewFoodTest() throws TooManyCaloriesException {
        FoodItem RegularFood = new RegularFood("Chips", 100);
        listManager.addNewFood(RegularFood);
        assertEquals(1, listManager.foodCount());
    }

    @Test
    public void deleteFoodIndexOnceTest() throws TooManyCaloriesException {
        FoodItem RegularFood = new RegularFood("Chips", 100);
        listManager.addNewFood(RegularFood);
        assertEquals(1, listManager.foodCount());
    }

    @Test
    public void deleteFoodIndexEmptyTest() {
        listManager.deleteFoodIndex(0);
        assertEquals(0, listManager.foodCount());
    }

    @Test
    public void foodCountNotEmptyTest() throws TooManyCaloriesException {
        FoodItem RegularFood = new RegularFood("Chips", 100);
        listManager.addNewFood(RegularFood);
        assertEquals(1, listManager.foodCount());
    }

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
    public void testGetTotalCaloriesConsumedPlus() throws TooManyCaloriesException {
        FoodItem apple = new RegularFood("Apple", 50);
        FoodItem pizza = new RegularFood("Pizza", 500);
        FoodItem soda = new RegularFood("Soda", 200);

        assertEquals(50, listManager.getTotalCaloriesConsumedPlus(apple.getCalorieCount()));
        assertEquals(500, listManager.getTotalCaloriesConsumedPlus(pizza.getCalorieCount()));

        listManager.addNewFood(apple);

        assertEquals(250, listManager.getTotalCaloriesConsumedPlus(soda.getCalorieCount()));
    }

    @Test
    public void testGetTotalCaloriesConsumed() throws TooManyCaloriesException {
        FoodItem apple = new RegularFood("Apple", 50);
        FoodItem pizza = new RegularFood("Pizza", 500);
        FoodItem soda = new RegularFood("Soda", 200);

        listManager.addNewFood(apple);
        listManager.addNewFood(pizza);
        listManager.addNewFood(soda);

        assertEquals(750, listManager.getTotalCaloriesConsumed());
    }

    @Test
    public void testGetFoodItemsOutputEmptyList() {
        String expectedOutput = "Eat some food to log!\n";
        assertEquals(expectedOutput, listManager.getFoodItemsOutput());
    }

}

