package src.network;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private boolean changed;
    public List<Observer> observers;

    // REQUIRES: observers and changed
    // EFFECTS:  constructs an observer arraylist
    public Observable() {
        this.changed = false;
        this.observers = new ArrayList<Observer>();
    }

    // REQUIRES: an Observer object as parameter
    // MODIFIES: this
    // EFFECTS: adds the Observer object to the observers list
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // REQUIRES: an Observer object as parameter
    // MODIFIES: this
    // EFFECTS: removes the Observer object from the observers list if it is in the list
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // MODIFIES: this
    // EFFECTS: calls the update method for each observer in the observers list
    public void notifyObservers() {
        if (changed) {
            for (Observer observer : observers) {
                observer.update(this);
            }
            changed = false;
        }
    }

    // MODIFIES: this
    // EFFECTS: sets the changed flag to true
    public void setChanged() {
        changed = true;
    }

    // EFFECTS: defines the Observer interface with an update method that takes an Observable object as parameter
    public interface Observer {
        void update(Observable o);
    }
}

