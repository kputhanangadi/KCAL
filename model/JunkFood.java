package model;

public class JunkFood extends FoodItem {
    private String type;
    private int calorieCount;

    public JunkFood(String name, int type, int calorieCount) {
        super(name);
        this.type = String.valueOf(type);
        this.calorieCount = calorieCount;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getCalorieCount() {
        return calorieCount;
    }

    @Override
    public String toString() {
        return "JUNK_FOOD --> [" +
                "name = " + getName() +
                " | calorieCount = " + type +
                " | sugarCount = " + calorieCount +
                ']';
    }
}

