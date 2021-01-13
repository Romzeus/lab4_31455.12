package lab4;
import lab4.lib.*;


public class Main {
    public static void main(String[] args){
        Rocket moonRocket = new Rocket();
        Rocket.ControlMachine moonControl = moonRocket.new ControlMachine();
        Button controlButton = new Button(moonControl);
        Dunno dunno = new Dunno("Незнайка");
        Donut donut = new Donut("Пончик");
        Villager villager = new Villager();
        String naming = "пищевой продукт";
        Button roomButton = ButtonFactory.getDoorButton();
        Button[] buttons = {
                ButtonFactory.getButton(naming, FurnitureType.FRIDGE),
                ButtonFactory.getButton(naming, FurnitureType.LOCKER),
                ButtonFactory.getButton(naming, FurnitureType.TERMOSTAT)
        };
        Button entryButton = new Button(new Door(){
            @Override
            public void use() {
                System.out.print("Раздается щелчок: ");
                super.use();
            }
        });
        Button lampButton = ButtonFactory.getLampButton();
        dunno.interact(entryButton);
        dunno.move(Location.ELEVATOR);
        donut.move(Location.ELEVATOR);
        dunno.move(Location.HALL);
        donut.move(Location.HALL);
        dunno.move(Location.ROOM);
        donut.move(Location.ROOM);
        dunno.interact(lampButton);
        donut.fall();
        dunno.see(donut);
        dunno.interact(roomButton);
        dunno.speak("");
        for (Button button : buttons){
            dunno.interact(button);
            donut.see(button.getControlledObject());
        }
        try {
            dunno.sleep();
            donut.sleep();
        } catch(WrongSleepCondition sleepCondition) {
            sleepCondition.toString();
        }
        donut.reject();
        donut.hear(dunno);
        donut.wake();
        donut.decide();
        for (int i = 0; i < 3; i++){
            donut.move(Location.HALL);
            donut.move(Location.KITCHEN);
        }
        donut.move(Location.HALL);
        donut.move(Location.CONTROLROOM);
        donut.misinterpret(controlButton);
        donut.interact(controlButton);
        donut.hear(moonRocket);
        villager.see(moonRocket);
    }
}
