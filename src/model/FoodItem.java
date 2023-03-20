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


