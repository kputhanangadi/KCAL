package model;

public class RegularFood extends FoodItem {
    private int calorieCount;

    public RegularFood(String name, int calorieCount) {
        super(name);
        this.calorieCount = calorieCount;
    }

    public RegularFood(String foodName) {
        super(foodName);
    }

    public int getCalorieCount() {
        return calorieCount;
    }

    public void setCalorieCount(int calorieCount) {
        this.calorieCount = calorieCount;
    }

    @Override
    public String toString() {
        return "REGULAR_FOOD --> [" +
                "name = " + getName() +
                " | calorieCount = " + calorieCount +
                ']';
    }
}

//// Represents a food item
//public class RegularFood extends Food {
//    private String name;
//
//    // EFFECTS: constructs a new food item
//    public RegularFood(String name) {
//        this.name = name;
//    }
//
//    // EFFECTS: outputs the food name
//    public String getName() {
//        return this.name;               // GETTER
//    }
//
//    public String twoString(){
//        return name;
//    }
//}
