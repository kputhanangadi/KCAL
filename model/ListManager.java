package model;

import java.util.ArrayList;
import java.util.List;

// Represents users daily food intake
public class ListManager implements Loadable, Saveable{
    List<RegularFood> regularFoodList;

    // EFFECTS: constructs a new selection system object
    public ListManager() {
        regularFoodList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a new tem into the food list
    public void addNewFood(String foodName) {
        regularFoodList.add(new RegularFood(foodName));
        System.out.println("Successfully added item into Foods Consumed Today!");
    }

    // REQUIRES: given int must be a valid index
    // MODIFIES: this
    // EFFECTS:  removes an item from the food list
    public void deleteFoodIndex(int index) {
        if (index >= 0 && index < regularFoodList.size()) {
            regularFoodList.remove(index);
            System.out.println("Successfully removed item from Foods Consumed Today.");
        } else {
            System.out.println("Invalid entry.");
        }
    }

    // EFFECTS: displays all food items stored in the food list
    public void showFoodItems() {
        if (regularFoodList.size() == 0) {
            System.out.println("Eat some food to log!");
        } else {
            System.out.println("Food Consumed: ");
            int index = 1;
            for (RegularFood item : regularFoodList) {
                System.out.println("[" + index++ + "] - " + item.getName());
            }
            System.out.println("--------------------------------------------------");
        }
    }

    // EFFECTS: returns the number of food items in the food list
    public int foodCount() {

        return regularFoodList.size();
    }

    public void load(){

    }

    public void save() {

    }

    public String getFoodItemsOutput() {
        StringBuilder sb = new StringBuilder();
        if (regularFoodList.size() == 0) {
            sb.append("Eat some food to log!\n");
        } else {
            sb.append("Food Consumed: \n");
            int index = 1;
            for (RegularFood item : regularFoodList) {
                sb.append("[" + index++ + "] - " + item.getName() + "\n");
            }
            sb.append("--------------------------------------------------\n");
        }
        return sb.toString();
    }

}
