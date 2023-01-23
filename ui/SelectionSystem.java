package ui;

import java.util.ArrayList;
import java.util.List;

public class SelectionSystem {
    List<Food> foodList;

    public SelectionSystem() {
        foodList = new ArrayList<>();
    }

    //  Adds entered food item into a list that can be accessed
    public void addNewFood(String foodName) {
        foodList.add(new Food(foodName));
        System.out.println("Successfully added item into Foods Consumed Today!");
    }

    // Takes in the index and removes the item in that index
    public void deleteFoodIndex(int index) {
        if (index >= 0 && index < foodList.size()) {
            foodList.remove(index);
            System.out.println("Successfully removed item from Foods Consumed Today.");
        } else {
            System.out.println("Invalid entry.");
        }
    }

    // Displays all the items in the calorie counter
    public void showFoodItems() {
        if (foodList.size() == 0) {
            System.out.println("Eat some food to log!");
        } else {
            System.out.println("Food Consumed: ");
            int index = 1;
            for (Food item : foodList) {
                System.out.println("[" + index++ + "] - " + item.name);
            }
            System.out.println("--------------------------------------------------");
        }
    }

    // Returns the total food count
    public int foodCount() {
        return foodList.size();
    }
}
