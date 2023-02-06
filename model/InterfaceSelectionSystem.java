package model;

import java.util.Scanner;

public class InterfaceSelectionSystem {

    public InterfaceSelectionSystem() {
        runSelectionSystem();
    }

    // Running Selection System
    public void runSelectionSystem() {
        Scanner scanner = new Scanner(System.in);
        ListManger listManger = new ListManger();
        int choice = 0;

        // REQUIRES: given int/string must be a valid index
        // MODIFIES: this
        // EFFECTS:  respective code is executed from the 4 options
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
                    listManger.addNewFood(foodItem);
                    break;
                case 2:
                    if (listManger.foodCount() > 0) {
                        listManger.showFoodItems();

                        System.out.print("Which food item would you like to delete:  ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        listManger.deleteFoodIndex(index - 1);
                    } else {
                        System.out.println("No food items are available.");
                    }
                    break;
                case 3:
                    listManger.showFoodItems();
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
