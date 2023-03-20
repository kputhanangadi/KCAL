package src.model;

public class RegularFood extends FoodItem {

    public RegularFood(String name, int calorieCount) {
        super(name, calorieCount);
    }

    // default calCount = 105
    public RegularFood(String foodName) {
        super(foodName, 105);
    }

    public int getCalorieCount() {
        return super.getCalorieCount();
    }

    public void setCalorieCount(int calorieCount) {
        super.calCount = calorieCount;
    }

    @Override
    public String toString() {
        return "REGULAR_FOOD --> [" +
                "name = " + getName() +
                " | calorieCount = " + super.getCalorieCount() +
                ']';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        FoodItem foodItem = (FoodItem) o;
//        return calCount == foodItem.calCount &&
//                Objects.equals(name, foodItem.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, calCount);
//    }
}
