package test;
import model.Food;

import model.SelectionSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {

    private Food food;

    @BeforeEach
    public void runBefore() {
        food = new Food("testing");
    }

    @Test
    public void testConstructor() {
        assertEquals("testing", food.getName());
    }
}
