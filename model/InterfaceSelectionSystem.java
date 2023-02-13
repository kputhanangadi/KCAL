package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InterfaceSelectionSystem {

    public InterfaceSelectionSystem() throws IOException {
        runSelectionSystem();
    }

    public static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    // Running Selection System
    public void runSelectionSystem() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));;
        PrintWriter writer = new PrintWriter("outputfile.txt","UTF-8");
        lines.add("Trey Coordinator");
        for (String line : lines){
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.print("Name: "+partsOfLine.get(0)+" ");
            System.out.println("Role: "+partsOfLine.get(1));
            writer.println(line);
        }
        writer.close(); //note -- if you miss this, the file will not be written at all.

        Scanner scanner = new Scanner(System.in);
        ListManager listManager = new ListManager();
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
                    listManager.addNewFood(foodItem);
                    break;
                case 2:
                    if (listManager.foodCount() > 0) {
                        listManager.showFoodItems();

                        System.out.print("Which food item would you like to delete:  ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        listManager.deleteFoodIndex(index - 1);
                    } else {
                        System.out.println("No food items are available.");
                    }
                    break;
                case 3:
                    listManager.showFoodItems();
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
