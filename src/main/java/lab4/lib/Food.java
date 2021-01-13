package lab4.lib;

public class Food {
    private final String foodName;
    public Food(){
        foodName = "пищевой продукт";
    }
    public Food(String foodName){
        this.foodName = foodName;
    }
    @Override
    public String toString(){
        return foodName;
    }
    @Override
    public int hashCode(){
        return foodName.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Food)
            return (object.toString().equals(this.toString()));
        return false;
    }
}
