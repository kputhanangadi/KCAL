package model;

public class RegularFood extends FoodItem {
    private int calorieCount;

    public RegularFood(String name, int calorieCount) {
        super(name, 105);
        this.calorieCount = calorieCount;
    }

    public RegularFood(String foodName) {
        super(foodName, 105);
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
