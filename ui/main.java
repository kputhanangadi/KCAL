package ui;

import java.util.Scanner;

public class main {

    //USER INPUT
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        //Code from Lecture 4
        Scanner scanner = new Scanner(System.in);
        int foodCount;
        //OBJECT
        CalorieCounter calorieCounter = new CalorieCounter();
        while (true) {
            System.out.println("How many food items did you eat today?");
            foodCount = Integer.parseInt(scanner.nextLine());
            if (foodCount > 0) {
                System.out.println("You have consumed " + foodCount + " items of food today.");
            } else {
                System.out.println("Eat some food to log!");
                break;
            }

        }
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
