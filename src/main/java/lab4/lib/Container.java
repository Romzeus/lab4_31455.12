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
}
