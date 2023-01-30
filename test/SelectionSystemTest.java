package test;

import model.SelectionSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelectionSystemTest {

    private SelectionSystem selectionSystem;

    @BeforeEach
    public void runBefore() {
        selectionSystem = new SelectionSystem();
    }

    @Test //TODO
    public void testConstructor() {

    }

    @Test //TODO
    public void addNewFoodTest() {

    }

    @Test
    public void deleteFoodIndexOnceTest() {
        selectionSystem.addNewFood("Chips");
        assertEquals(1, selectionSystem.foodCount());
        selectionSystem.deleteFoodIndex(0);
        assertEquals(0, selectionSystem.foodCount());
    }

    @Test //TODO
    public void deleteFoodIndexEmptyTest() {

    }

    @Test //TODO
    public void showFoodItemsNotEmptyTest() {

    }

    @Test //TODO
    public void showFoodItemsEmptyTest() {

    }

    @Test
    public void foodCountEmptyTest() {

    }

    @Test
    public void foodCountNotEmptyTest() {

    }

}
