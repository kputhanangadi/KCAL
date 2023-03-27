package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.model.FoodItem;
import src.model.ListManager;
import src.model.RegularFood;
import src.model.TooManyCaloriesException;

import static org.junit.Assert.*;

public class TooManyCaloriesExceptionTest {

    private ListManager listManager = new ListManager();

    @BeforeEach
    public void runBefore() {
        listManager = new ListManager();
    }

    @Test
    public void testConstructor() {
        TooManyCaloriesException e = new TooManyCaloriesException();
        assertNotNull(e);
    }

    @Test
    public void addNewFoodTooManyCalsTest() throws TooManyCaloriesException {
        FoodItem food = new RegularFood("Chips", 2500);
        FoodItem anotherFood = new RegularFood("cookie", 1);
        listManager.addNewFood(food);
        try {
            listManager.addNewFood(anotherFood);
            fail();
        } catch (TooManyCaloriesException e) {
            System.out.println("caught!");
            assertEquals(1, listManager.foodCount());
        }
    }
}

