package test;

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

    @Test
    public void showFoodItemsNotEmptyTest() {
        listManager.addNewFood("Chips");
        assertEquals(1, listManager.foodCount());
        listManager.showFoodItems();
        assertEquals(1, listManager.foodCount());
    }

    @Test
    public void showFoodItemsEmptyTest() {
        listManager.showFoodItems();
        assertEquals(0, listManager.foodCount());
    }

    @Test
    public void foodCountNotEmptyTest() {
        listManager.addNewFood("Chips");
        assertEquals(1, listManager.foodCount());
    }

    @Test
    public void foodCountEmptyTest() {
        assertEquals(0, listManager.foodCount());
    }

}
