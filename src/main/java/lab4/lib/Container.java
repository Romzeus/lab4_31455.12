package lab4.lib;

public class Container extends Furniture{
    private final FurnitureType naming;
    private final Food food;
    public Container(FurnitureType naming, Food food){
        super(false);
        this.naming = naming;
        this.food = food;
    }
    public String getFoodName() {
        return food.toString();
    }
    @Override
    public void use(){
        this.changeCondition();
        System.out.println(this.naming.type() + " " + (this.getCondition() ? "открыт": "закрыт"));
    }
    @Override
    public int hashCode(){
        int i = 0;
        switch(naming){
            case LOCKER:
                i += 1;
                break;
            case TERMOSTAT:
                i += 2;
                break;
            case FRIDGE:
                i += 3;
                break;
            default:
                i += 0;
        }
        if (food.toString().equals("пищевой продукт"))
            i += 1;
        return i;
    }
    @Override
    public String toString(){
        return (naming.type() + " с " + food.toString());
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Container)
            return (((Container)obj).getFoodName().equals(this.getFoodName())) && (((Container)obj).getCondition() == this.getCondition());
        return false;
    }

    public static class Food {
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
}
