package src.model;

public class JunkFood extends FoodItem {
    private int type;

    public JunkFood(String name, int type, int calorieCount) {
        super(name, calorieCount);
        super.listManager = null;
        this.type = type;
    }

    public int getType() {
        return type;
    }

//    public void addManager(ListManager listManager) throws TooManyCaloriesException {
//        if (this.listManager != listManager) {
//            if (this.listManager != null) {
//                this.removeManager();
//            }
//            this.listManager = listManager;
//            this.listManager.addNewFood(this);
//        }
//    }
//
//    public void removeManager() {
//        if (listManager != null) {
//            ListManager temp = listManager;
//            this.listManager = null;
//            temp.deleteFoodIndex(listManager.foodItemList.indexOf(this));
//        }
//    }

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

