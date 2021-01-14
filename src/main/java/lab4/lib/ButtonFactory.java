package lab4.lib;

public class ButtonFactory {
    public static Button getButton(){
        return ButtonFactory.getButton("пищевой продукт", FurnitureType.FRIDGE);
    }
    public static Button getButton(String foodName, FurnitureType furnitureType){
        Container.Food food = new Container.Food(foodName);
        Furniture furniture = new Container(furnitureType, food);
        Button button = new Button(furniture);
        return button;
    }
    public static Button getDoorButton(){
        Furniture door = new Door();
        Button button = new Button(door);
        return button;
    }
    public static Button getLampButton() {
        class Lamp extends Furniture {
            Lamp(){
                super(false);
            }
            @Override
            public void use() {
                this.changeCondition();
                System.out.println(this.toString() + (this.getCondition()? " включена": " выключена"));
            }
            @Override
            public String toString() {
                return "Лампа";
            }
        }
        Lamp lamp = new Lamp();
        Button button = new Button(lamp);
        return button;
    }
}
