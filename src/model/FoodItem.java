package src.model;

public abstract class FoodItem {
    private String name;
    protected int calCount;

    public FoodItem(String name, int i) {
        this.name = name;
        this.calCount = i;
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


