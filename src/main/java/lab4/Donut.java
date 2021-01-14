package lab4;

import lab4.lib.*;

public class Donut extends BetterShorty implements Fallable{
    private boolean condition = false;
    private int sadness;
    public Donut(String name){
        super(name);
        sadness = 3;
    }
    @Override
    public void see(Object object){
        System.out.print(this.toString() + " видит ");
        if (object instanceof Container)
            if (((Furniture)object).getCondition())
                System.out.println(((Container)object).getFoodName() + ", " + (this.sadness > 0 ? "но даже это его не " : "и это его ") + "радует");
        else
            System.out.println(object.toString());
    }
    @Override
    public void fall(){
        condition = true;
        System.out.println(this.toString() + " падает");
    }
    public void standUp() {
        condition = false;
        System.out.println(toString() + " встал");
    }
    @Override
    public void move(Location location) {
        if (isFallen())
            throw new WrongCondition(toString());
        else
            super.move(location);
    }
    public void changeSadness(int change){
        sadness += change;
    }
    @Override
    public boolean isFallen() {
        return condition;
    }
    @Override
    public boolean equals(Object object){
        if (object instanceof Donut)
            return (object.toString().equals(this.toString())) && (((Donut)object).isFallen() == this.isFallen()) && (((Donut)object).isAsleep() == this.isAsleep());
        return false;
    }
    @Override
    public void sleep() {
        super.sleep();
        System.out.println(this.toString() + " устроился поудобнее на мягкой пластмассе");
    }
    @Override
    public void wake() {
        super.wake();
        condition = false;
        System.out.println(toString() + " поднялся");
    }
    public void decide() {
        if (sadness > 2)
            System.out.println(toString() + " решил выбраться из ракеты");
        else
            System.out.println(toString() + " решил остаться в ракете");
    }
    public void hear(Object object) {
        String sound;
        System.out.print(toString() + " прислушивается к " + object.toString());
        try {
            sound = Sound.getSound(object);
        } catch(NoSoundException noSound) {
            sound = "ничего";
        }
        System.out.println(" и слышит " + sound);
    }
    public void reject() {
        if (sadness > 2)
            System.out.println(this.toString() + " не хочет лететь");
        else
            System.out.println(this.toString() + " все еще хочет лететь");
    }
    public void misinterpret(Object object) {
        System.out.println(this.toString() + " перепутал" + object.toString());
    }
}
