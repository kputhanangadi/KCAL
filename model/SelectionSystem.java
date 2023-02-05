package model;

import model.Food;
import java.util.ArrayList;
import java.util.List;

// Represents users daily food intake
public class SelectionSystem {
    List<Food> foodList;

    // EFFECTS: constructs a new selection system object
    public SelectionSystem() {
        foodList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a new tem into the food list
    public void addNewFood(String foodName) {
        foodList.add(new Food(foodName));
        System.out.println("Successfully added item into Foods Consumed Today!");
    }

    // REQUIRES: given int must be a valid index
    // MODIFIES: this
    // EFFECTS:  removes an item from the food list
    public void deleteFoodIndex(int index) {
        if (index >= 0 && index < foodList.size()) {
            foodList.remove(index);
            System.out.println("Successfully removed item from Foods Consumed Today.");
        } else {
            System.out.println("Invalid entry.");
        }
    }

    // EFFECTS: displays all food items stored in the food list
    public void showFoodItems() {
        if (foodList.size() == 0) {
            System.out.println("Eat some food to log!");
        } else {
            System.out.println("Food Consumed: ");
            int index = 1;
            for (Food item : foodList) {
                System.out.println("[" + index++ + "] - " + item.getName());
            }
            System.out.println("--------------------------------------------------");
        }
    }

    // EFFECTS: returns the number of food items in the food list
    public int foodCount() {
        return foodList.size();
    }
}
