package test;

import model.JunkFood;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class JunkFoodTest {

    @Test
    public void testJunkFoodConstructor() {
        JunkFood food = new JunkFood("Chocolate Bar", 1, 230);
        assertEquals("Chocolate Bar", food.getName());
        assertEquals("1", food.getType());
        assertEquals(230, food.getCalorieCount());
    }

    @Test
    public void testGetType() {
        JunkFood food = new JunkFood("Chocolate Bar", 1, 230);
        assertEquals("1", food.getType());
    }

    @Test
    public void testGetCalorieCount() {
        JunkFood food = new JunkFood("Chocolate Bar", 1, 230);
        assertEquals(230, food.getCalorieCount());
    }

    @Test
    void testToString() {
    }
}