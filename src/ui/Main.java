package src.ui;

import src.network.WebDataReader;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Main {

    // RUNNING THE PROGRAM
    public static void main(String[] args) throws IOException {

        // READING WEB DATA
        WebDataReader reader = new WebDataReader();
        reader.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("Data read from web page: ");
                System.out.println(((WebDataReader)o).getData());
            }
        });
        try { reader.readData("https://www.students.cs.ubc.ca/~cs-210/2018w1/welcomemsg.html");
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }

        // THE ACTUAL CALORIE COUNTER
        new InterfaceSelectionSystem();
    }
}
