package src.ui;

import src.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InterfaceSelectionSystem {

    public InterfaceSelectionSystem() throws IOException {
        runSelectionSystem();
    }

    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    // Running Selection System
    public void runSelectionSystem() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ListManager listManager = new ListManager();
        int choice = 0;

        // REQUIRES: given int/string must be a valid index
        // MODIFIES: this
        // EFFECTS:  respective code is executed from the 6 options
        while (true) {
            System.out.println("[1] Add a Regular Food item to the Food Consumed List.");
            System.out.println("[2] Add a Junk Food item to the Food Consumed List.");
            System.out.println("[3] Remove an item from the Food Consumed List.");
            System.out.println("[4] Show all items in the Food Consumed List.");
            System.out.println("[5] Calculate total calories consumed.");
            System.out.println("[6] Quit Program.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter a regular food item that you have consumed: ");
                    String regularFoodItem = scanner.nextLine();
                    System.out.print("Enter the number of calories in " + regularFoodItem + ": ");
                    int regularFoodCalories = scanner.nextInt();
                    scanner.nextLine();
                    RegularFood regularFood = new RegularFood(regularFoodItem, regularFoodCalories);
                    try {
                        listManager.addNewFood(regularFood);
                    } catch (TooManyCaloriesException e) {
                        System.out.println("Exceeded daily calorie intake.\n");
                    } finally {
                        break;
                    }
                case 2:
                    System.out.print("Enter a junk food item that you have consumed: ");
                    String junkFoodItem = scanner.nextLine();
                    System.out.print("Enter the number of calories in " + junkFoodItem + ": ");
                    int junkFoodCalories = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the amount of sugar in " + junkFoodItem + ": ");
                    int junkFoodSugar = scanner.nextInt();
                    scanner.nextLine();
                    JunkFood junkFood = new JunkFood(junkFoodItem, junkFoodCalories, junkFoodSugar);
                    try {
                        listManager.addNewFood(junkFood);
                    } catch (TooManyCaloriesException e) {
                        System.out.println("Exceeded daily calorie intake.");
                    } finally {
                        break;
                    }
                case 3:
                    if (listManager.foodCount() > 0) {
                            if (listManager.foodItemList.size() == 0) {
                                System.out.println("Eat some food to log!" + "\n");
                            } else {
                                System.out.println("Food Consumed: ");
                                int index = 1;
                                for (FoodItem item : listManager.foodItemList) {
                                    System.out.println("[" + index++ + "] - " + item.getName());
                                }
                                System.out.println("\n");
                            }
//                        listManager.showFoodItems();

                        System.out.print("Which food item would you like to delete:  ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        listManager.deleteFoodIndex(index - 1);
                    } else {
                        System.out.println("No food items are available." + "\n");
                    }
                    break;
                case 4:
                    if (listManager.foodItemList.size() == 0) {
                        System.out.println("Eat some food to log!" + "\n");
                    } else {
                        System.out.println("Food Consumed: ");
                        int index = 1;
                        for (FoodItem item : listManager.foodItemList) {
                            System.out.println("[" + index++ + "] - " + item.getName());
                        }
                        System.out.println("\n");
                    }
//                    listManager.showFoodItems();
                    break;
                case 5:
                    System.out.println("Total calories consumed: " + listManager.getTotalCaloriesConsumed() + "\n");
                    break;
//                case 6:
//                    System.out.println("Keep up the good work!" + "\n");
//                    break;
//                case 6:
//                    PrintWriter writer = new PrintWriter("src/outputfile.txt", "UTF-8");
//                    listManager.getFoodItemsOutput();
//                    System.out.print("LOADED DATA:\n" + listManager.getFoodItemsOutput() + "\n");
////                    for (String line : line){
////                        System.out.print("LOADED DATA:\n" + "New Food\n" + "---------------------------\n");
////                        writer.println(line);
////                    }
//                    writer.close(); // note -- if you miss this, the file will not be written at all.
//                    break;
                default:
                    System.out.println("Invalid selection.");
            }
            if (choice == 6) break;
        }
        System.out.println("Keep up the good work!" + "\n");
    }
    // LINK TO EVERYTHING IN MAIN
}