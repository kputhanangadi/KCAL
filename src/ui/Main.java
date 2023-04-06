import src.network.WebDataReader;
import src.ui.InterfaceSelectionSystemTerminal;
import src.ui.InterfaceSelectionSystem;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Main {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        // READING WEB DATA
        // EFFECTS:  creates a reader of type WebDataReader
        WebDataReader reader = new WebDataReader();

        // ADDING OBSERVERS
        // REQUIRES: data within the WebDataReader
        // MODIFIES: this
        // EFFECTS:  adds an observer to print the data when it is read
        reader.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("DATA READ: " + ((WebDataReader)o).getData());
            }
        });

        // CONSOLE OBSERVER
        // EFFECTS:  creates a reader of type WebDataReader
        reader.addObserver(new ConsoleObserver());

        // READING DATA FROM WEB PAGE
        // EFFECTS:  reads data from the given URL and notifies observers
        try {
            reader.readData("https://www.students.cs.ubc.ca/~cs-210/2018w1/welcomemsg.html");
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }

        // THE ACTUAL CALORIE COUNTER [UNCOMMENT TO VIEW CONSOLE APPLICATION]
        // EFFECTS:  runs the calorie counter in the console
        new InterfaceSelectionSystemTerminal();

        // GUI [UNCOMMENT TO VIEW GUI APPLICATION]
        // EFFECTS:  creates a GUI for the calorie counter and sets it visible
//        InterfaceSelectionSystem gui = new InterfaceSelectionSystem();
//        gui.setVisible(true);

    }

    // NEW OBSERVER CLASS
    // REQUIRES: observable and object
    // MODIFIES: this
    // EFFECTS:  creates a GUI for the calorie counter and sets it visible
    static class ConsoleObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("TRIGGER: Webreader has read the data successfully.");
        }
    }

}

