package ui;


import java.util.Scanner;
import model.Food;
import model.SelectionSystem;

public class Main {

    // User input
    public static void main(String[] args) {

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
}

//    //LAB ONE
//    public static void main(String[] args) {
//        methodname1();
//        methodname2();
//    }
//    public static void methodname1(){
//        System.out.println("Done1");
//    }
//    public static void methodname2(){
//        System.out.println("Done2");
//    }
//}
