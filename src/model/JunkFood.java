package src.model;

public class JunkFood extends FoodItem {

    private int type;

    // REQUIRES: a name, type, and calorieCount
    // EFFECTS:  constructs a junk food object
    public JunkFood(String name, int type, int calorieCount) {
        super(name, calorieCount);
        super.listManager = null;
        this.type = type;
    }

    // REQUIRES: a type
    // EFFECTS:  returns the type of food
    public int getType() {
        return type;
    }

    @Override
    public int getCalorieCount() {
        return super.getCalorieCount();
    }

    @Override
    public String toString() {
        return "JUNK_FOOD --> [" +
                "name = " + getName() +
                " | calorieCount = " + type +
                " | sugarCount = " + super.getCalorieCount() +
                ']';
    }

}

