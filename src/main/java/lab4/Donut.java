package lab4;

import lab4.lib.*;

public class Donut extends BetterShorty implements FallGuy{
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
            return (object.toString().equals(this.toString())) && (((Donut)object).isFallen() == this.isFallen());
        return false;
    }
    @Override
    public void sleep() {
        System.out.println(this.toString() + " устроился поудобнее на мягкой пластмассе");
    }
    @Override
    public void wake() {
        System.out.println(toString() + " поднялся");
    }
    public void decide() {
        System.out.println(toString() + " решил " + "выбраться из ракеты");
    }
    public void hear(Object object) {
        System.out.print(toString() + " прислушивается к " + object.toString());
        if (object instanceof BetterShorty)
            if (((BetterShorty) object).isAsleep())
                System.out.print(" и слышит мерное похрапывание");
        else if (object instanceof Rocket)
            if (((Rocket) object).isFlightMode())
                System.out.print(" и слышит мерный шум заработавшего ракетного двигателя");
        System.out.println();
    }
    public void reject() {
        System.out.println(this.toString() + " не хочет лететь");
    }
    public void misinterpret(Object object) {
        System.out.println(this.toString() + " перепутал" + object.toString());
    }
}
