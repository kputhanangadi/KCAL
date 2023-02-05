package test;
import model.SelectionSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectionSystemTest {

    private SelectionSystem selectionSystem;

    @BeforeEach
    public void runBefore() {
        selectionSystem = new SelectionSystem();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, selectionSystem.foodCount());
    }

    @Test
    public void addNewFoodTest() {
        selectionSystem.addNewFood("Chips");
        assertEquals(1, selectionSystem.foodCount());
    }

    @Test
    public void deleteFoodIndexOnceTest() {
        selectionSystem.addNewFood("Chips");
        assertEquals(1, selectionSystem.foodCount());
        selectionSystem.deleteFoodIndex(0);
        assertEquals(0, selectionSystem.foodCount());
    }

    @Test
    public void deleteFoodIndexEmptyTest() {
        selectionSystem.deleteFoodIndex(0);
        assertEquals(0, selectionSystem.foodCount());
    }

    @Test
    public void showFoodItemsNotEmptyTest() {
        selectionSystem.addNewFood("Chips");
        assertEquals(1, selectionSystem.foodCount());
        selectionSystem.showFoodItems();
        assertEquals(1, selectionSystem.foodCount());
    }

    @Test
    public void showFoodItemsEmptyTest() {
        selectionSystem.showFoodItems();
        assertEquals(0, selectionSystem.foodCount());
    }

    @Test
    public void foodCountNotEmptyTest() {
        selectionSystem.addNewFood("Chips");
        assertEquals(1, selectionSystem.foodCount());
    }

    @Test
    public void foodCountEmptyTest() {
        assertEquals(0, selectionSystem.foodCount());
    }

}
