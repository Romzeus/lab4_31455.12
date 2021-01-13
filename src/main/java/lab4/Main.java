package lab4;
import lab4.lib.*;


public class Main {
    public static void main(String[] args){
        Rocket moonRocket = new Rocket();
        Rocket.ControlMachine moonControl = moonRocket.new ControlMachine();
        Button controlButton = new Button(moonControl);
        Dunno dunno = new Dunno("Незнайка");
        Donut donut = new Donut("Пончик");
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
        dunno.sleep();
        donut.sleep();
        donut.think(new Thought("ему лучше отказаться от этого путешествия"));
        donut.decide(new Thought("признаться " + dunno.toString() + ", что он уже расхотел лететь"));
        donut.think(new Thought(dunno.toString() + " начнет смеяться и упрекать в трусости"));
        donut.hear(dunno);
        donut.wake();
        donut.think(new Thought("он вылезет из ракеты и убежит домой, а " + dunno.toString() + " полетит на Луну, если ему так хочется"));
        for (int i = 0; i < 3; i++){
            donut.move(Location.HALL);
            donut.move(Location.KITCHEN);
        }
        donut.move(Location.HALL);
        donut.move(Location.CONTROLROOM);
        donut.think(new Thought(controlButton.toString() + " это переключатель света"));
        donut.interact(controlButton);
        donut.hear(moonRocket);
        Assumption assumption = new Assumption(new Thought("Кто-то из жителей Космического городка в этот момент проснулся"), new Thought("он был бы очень удивлен увиденным"));
        assumption.assume();
    }
}
