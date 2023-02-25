package model;

// Represents a food item
public class RegularFood extends Food {
    private String name;

    // EFFECTS: constructs a new food item
    public RegularFood(String name) {
        this.name = name;
    }

    // EFFECTS: outputs the food name
    public String getName() {
        return this.name;               // GETTER
    }

    public String twoString(){
        return name;
    }
}
