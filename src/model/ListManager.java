package src.model;

import java.util.ArrayList;
import java.util.List;


public class ListManager implements InterfaceLoadable, InterfaceSaveable {

    public List<FoodItem> foodItemList;

    // EFFECTS: constructs a new selection system object
    public ListManager() {
        foodItemList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a new item into the foodIemList
    public void addNewFood(FoodItem item) throws TooManyCaloriesException {
        if (!this.foodItemList.contains(item)) {
            if (this.getTotalCaloriesConsumedPlus(item.getCalorieCount()) > 2500) {
                throw new TooManyCaloriesException();
            }
            if (this.foodItemList != null) {
                foodItemList.add(item);
                item.addManager(this);
                System.out.println("Successfully added item into Foods Consumed Today!");
            }
        }
    }

    // REQUIRES: given int must be a valid index
    // MODIFIES: this
    // EFFECTS:  removes an item from the foodIemList
    public void deleteFoodIndex(int index) {
        if (index >= 0 && index < foodItemList.size()) {
            foodItemList.remove(index);
            System.out.println("Successfully removed item from Foods Consumed Today.");
        } else {
            System.out.println("Invalid entry.");
        }
    }

    // EFFECTS: returns the number of food items in the foodIemList
    public int foodCount() {
        return foodItemList.size();
    }

    // REQUIRES: a saved file
    // EFFECTS:  loads file
    public void load(){

    }

    // REQUIRES: food to be stored to be foodIemList
    // EFFECTS: saves file
    public void save() {

    }

    // EFFECTS: creates a list of food that the user has consumed
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

    // REQUIRES: food to be stored to be foodIemList
    // MODIFIES: this
    // EFFECTS:  gets the total number of calories consumed
    public int getTotalCaloriesConsumed() {
        int totalCalories = 0;
        for (FoodItem food : foodItemList) {
            totalCalories += food.getCalorieCount();
        }
        return totalCalories;
    }

    // REQUIRES: food to be stored to be foodIemList
    // MODIFIES: this
    // EFFECTS:  gets the total number of calories consumed including the food item that is being added to the foodIemList
    public int getTotalCaloriesConsumedPlus(int newItemCals) {
        int totalCalories = 0;
        for (FoodItem food : foodItemList) {
            totalCalories += food.getCalorieCount();
        }
        totalCalories += newItemCals;
        return totalCalories;
    }

}
