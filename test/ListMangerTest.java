package test;
import model.ListManger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListMangerTest {

    private ListManger listManger;

    @BeforeEach
    public void runBefore() {
        listManger = new ListManger();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, listManger.foodCount());
    }

    @Test
    public void addNewFoodTest() {
        listManger.addNewFood("Chips");
        assertEquals(1, listManger.foodCount());
    }

    @Test
    public void deleteFoodIndexOnceTest() {
        listManger.addNewFood("Chips");
        assertEquals(1, listManger.foodCount());
        listManger.deleteFoodIndex(0);
        assertEquals(0, listManger.foodCount());
    }

    @Test
    public void deleteFoodIndexEmptyTest() {
        listManger.deleteFoodIndex(0);
        assertEquals(0, listManger.foodCount());
    }

    @Test
    public void showFoodItemsNotEmptyTest() {
        listManger.addNewFood("Chips");
        assertEquals(1, listManger.foodCount());
        listManger.showFoodItems();
        assertEquals(1, listManger.foodCount());
    }

    @Test
    public void showFoodItemsEmptyTest() {
        listManger.showFoodItems();
        assertEquals(0, listManger.foodCount());
    }

    @Test
    public void foodCountNotEmptyTest() {
        listManger.addNewFood("Chips");
        assertEquals(1, listManger.foodCount());
    }

    @Test
    public void foodCountEmptyTest() {
        assertEquals(0, listManger.foodCount());
    }

}
