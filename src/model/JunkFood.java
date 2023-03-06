package src.model;

public class JunkFood extends FoodItem {
    private int type;

    public JunkFood(String name, int type, int calorieCount) {
        super(name, calorieCount);
        this.type = type;
    }

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

