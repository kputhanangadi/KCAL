package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceSelectionSystem {

    public InterfaceSelectionSystem() {
        runSelectionSystem();
    }

    // Running Selection System
    public void runSelectionSystem() {
        Scanner scanner = new Scanner(System.in);
        SelectionSystem selectionSystem = new SelectionSystem();
        int choice = 0;

        // CODE USED FROM CONTENT
        while (true) {
            System.out.println("[1] Add an item to the Food Consumed List.");
            System.out.println("[2] Remove an item from the Food Consumed List.");
            System.out.println("[3] Show all items in the Food Consumed List.");
            System.out.println("[4] Quit Program.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter a food item that you have consumed: ");
                    String foodItem = scanner.nextLine();
                    selectionSystem.addNewFood(foodItem);
                    break;
                case 2:
                    if (selectionSystem.foodCount() > 0) {
                        selectionSystem.showFoodItems();

                        System.out.print("Which food item would you like to delete:  ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        selectionSystem.deleteFoodIndex(index - 1);
                    } else {
                        System.out.println("No food items are available.");
                    }
                    break;
                case 3:
                    selectionSystem.showFoodItems();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
            if (choice == 4) break;
        }
        System.out.println("Keep up the good work!");
    }
    // LINK TO EVERYTHING IN MAIN
}
