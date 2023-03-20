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

