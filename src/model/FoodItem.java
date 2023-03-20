package src.model;

import java.util.Objects;

public abstract class FoodItem {
    protected ListManager listManager;
    protected String name;
    protected int calCount;

    public FoodItem(String name, int i) {
        this.name = name;
        this.calCount = i;
        listManager = null;
    }

    public String getName() {
        return name;
    }

    public int getCalorieCount() {
        return this.calCount;
    }

    public void addManager(ListManager listManager) throws TooManyCaloriesException {
        if (this.listManager != listManager) {
            if (this.listManager != null) {
                this.removeManager();
            }
            this.listManager = listManager;
            this.listManager.addNewFood(this);
        }
    }

    public void removeManager() {
        if (listManager != null) {
            ListManager temp = listManager;
            this.listManager = null;
            temp.deleteFoodIndex(listManager.foodItemList.indexOf(this));
        }
    }

    @Override
    public String toString() {
        return "FoodItem [" +
                "name =" + name +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return calCount == foodItem.calCount &&
                Objects.equals(name, foodItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calCount);
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


