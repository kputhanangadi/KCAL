import src.network.WebDataReader;
import src.ui.InterfaceSelectionSystem;
import src.ui.InterfaceSelectionSystemGUI;

import javax.swing.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Main {

    // RUNNING THE PROGRAM
    public static void main(String[] args) throws IOException {

        // READING WEB DATA
        WebDataReader reader = new WebDataReader();

        // ADDING OBSERVERS
        reader.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("DATA READ: " + ((WebDataReader)o).getData());
            }
        });

        // CONSOLE OBSERVER
        reader.addObserver(new ConsoleObserver());

        // READING DATA FROM WEB PAGE
        try {
            reader.readData("https://www.students.cs.ubc.ca/~cs-210/2018w1/welcomemsg.html");
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }

        // THE ACTUAL CALORIE COUNTER
//        new InterfaceSelectionSystem();

        // GUI
        InterfaceSelectionSystemGUI gui = new InterfaceSelectionSystemGUI();
//        gui.pack();
        gui.setVisible(true);

    }

    // NEW OBSERVER CLASS
    static class ConsoleObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("TRIGGER: Webreader has read the data successfully.");
        }
    }

}

