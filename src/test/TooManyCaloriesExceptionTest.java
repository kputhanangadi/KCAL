package src.test;

import org.junit.Test;
import src.model.FoodItem;
import src.model.ListManager;
import src.model.RegularFood;
import src.model.TooManyCaloriesException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TooManyCaloriesExceptionTest {


    @Test
    public void testConstructor() {
        TooManyCaloriesException e = new TooManyCaloriesException();

        assertNotNull(e);
    }

    @Test
    public void addNewFoodTooManyCalsTest() throws TooManyCaloriesException {
        ListManager listManager = new ListManager();
        FoodItem food = new RegularFood("Chips", 2500);
        FoodItem anotherFood = new RegularFood("cookie", 1);
        listManager.addNewFood(food);
        try {
            listManager.addNewFood(anotherFood);
        } catch (TooManyCaloriesException e) {
            System.out.println("caught!");
            assertEquals(1, listManager.foodCount());
        }
    }
}

