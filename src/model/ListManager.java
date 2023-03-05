package src.model;

import java.util.ArrayList;
import java.util.List;

// Represents users daily food intake
public class ListManager implements InterfaceLoadable, InterfaceSaveable {
    List<FoodItem> foodItemList;

    // EFFECTS: constructs a new selection system object
    public ListManager() {
        foodItemList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a new tem into the food list
    public void addNewFood(String foodName) {
        foodItemList.add(new FoodItem(foodName, 105) {
            @Override
            public int getCalorieCount() {
                return 0;
            }
        });
        System.out.println("Successfully added item into Foods Consumed Today!");
    }

    // REQUIRES: given int must be a valid index
    // MODIFIES: this
    // EFFECTS:  removes an item from the food list
    public void deleteFoodIndex(int index) {
        if (index >= 0 && index < foodItemList.size()) {
            foodItemList.remove(index);
            System.out.println("Successfully removed item from Foods Consumed Today.");
        } else {
            System.out.println("Invalid entry.");
        }
    }

    // EFFECTS: displays all food items stored in the food list
    public void showFoodItems() {
        if (foodItemList.size() == 0) {
            System.out.println("Eat some food to log!" + "\n");
        } else {
            System.out.println("Food Consumed: ");
            int index = 1;
            for (FoodItem item : foodItemList) {
                System.out.println("[" + index++ + "] - " + item.getName());
            }
            System.out.println("\n");
        }
    }

    // EFFECTS: returns the number of food items in the food list
    public int foodCount() {

        return foodItemList.size();
    }

    public void load(){

    }

    public void save() {

    }

    public String getFoodItemsOutput() {
        StringBuilder sb = new StringBuilder();
        if (foodItemList.size() == 0) {
            sb.append("Eat some food to log!\n");
        } else {
            sb.append("Food Consumed: \n");
            int index = 1;
            for (FoodItem item : foodItemList) {
                sb.append("[" + index++ + "] - " + item.getName() + "\n");
            }
            sb.append("--------------------------------------------------\n");
        }
        return sb.toString();
    }

    public int getTotalCaloriesConsumed() {
        int totalCalories = 0;
        for (FoodItem food : foodItemList) {
            totalCalories += food.getCalorieCount();
        }
        return totalCalories;
    }

}
