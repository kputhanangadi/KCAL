package model;

// Represents a food item
public class Food {
    private String name;

    // EFFECTS: constructs a new food item
    public Food(String name) {
        this.name = name;
    }

    // EFFECTS: outputs the food name
    public String getName() {
        return this.name;               // GETTER
    }
}
