package src.model;

import java.util.Objects;

public abstract class FoodItem {

    protected ListManager listManager;
    protected String name;
    protected int calCount;

    // REQUIRES: a name and calorie(s)
    // EFFECTS:  constructs a food item object
    public FoodItem(String name, int i) {
        this.name = name;
        this.calCount = i;
        listManager = null;
    }

    // REQUIRES: a food item to be in the foodIemList
    // EFFECTS:  returns the name of the food item
    public String getName() {
        return name;
    }

    // REQUIRES: a food item to be in the foodIemList
    // EFFECTS:  gets the calorie count of all items in the foodIemList
    public int getCalorieCount() {
        return this.calCount;
    }

    // MODIFIES: this
    // EFFECTS: adds a new item into the foodIemList
    public void addManager(ListManager listManager) throws TooManyCaloriesException {
        if (this.listManager != listManager) {
            if (this.listManager != null) {
                this.removeManager(); //TODO
            }
            this.listManager = listManager;
            this.listManager.addNewFood(this);
        }
    }

    // TODO
    // REQUIRES: a food item to be in the foodIemList
    // MODIFIES: this
    // EFFECTS:  removes an item from the food list
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
}


