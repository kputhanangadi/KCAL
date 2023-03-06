package src.model;

public abstract class FoodItem {
    private String name;

    public FoodItem(String name, int i) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCalorieCount() {
        return this.calCount;
    }

    @Override
    public String toString() {
        return "FoodItem [" +
                "name =" + name +
                ']';
    }
}


