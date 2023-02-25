package test;
import model.RegularFood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegularFoodTest {

    private RegularFood regularFood;

    @BeforeEach
    public void runBefore() {
        regularFood = new RegularFood("testing");
    }

    @Test
    public void testConstructor() {
        assertEquals("testing", regularFood.getName());
    }
}
