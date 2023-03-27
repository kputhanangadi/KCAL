package src.model;

public class RegularFood extends FoodItem {

    // REQUIRES: a name and calorieCount
    // EFFECTS:  constructs a regular food object
    public RegularFood(String name, int calorieCount) {
        super(name, calorieCount);
        super.listManager = null;
    }

    // REQUIRES: a foodName
    // EFFECTS:  default calCount = 105
    public RegularFood(String foodName) {
        super(foodName, 105);
    }

    // REQUIRES: a food item
    // EFFECTS:  gets the calorie count of a food item
    public int getCalorieCount() {
        return super.getCalorieCount();
    }

    // REQUIRES: a food item
    // EFFECTS:  sets the calorie count of a food item
    public void setCalorieCount(int calorieCount) {
        super.calCount = calorieCount;
    }

//    @Override
//    public String toString() {
//        return "REGULAR_FOOD --> [" +
//                "name = " + getName() +
//                " | calorieCount = " + super.getCalorieCount() +
//                ']';
//    }

}
