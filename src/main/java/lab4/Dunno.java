package lab4;
import lab4.lib.*;


public class Dunno extends BetterShorty{
    public Dunno(String name){
        super(name);
    }
    @Override
    public void see(Object object) {
        if (isAsleep())
            throw new WrongCondition(toString());
        else {
            System.out.print(this.toString() + " видит: " + object.toString());
            if (object instanceof Fallable)
                System.out.println(((Fallable) object).isFallen() ? " упал" : " стоит");
        }
    }
    public void speak(String message){
        if (isAsleep())
            throw new WrongCondition(toString());
        else
            System.out.println(this.toString() + " говорит с широкой улыбкой: " + message);
    }
    @Override
    public boolean equals(Object object){
        if (object instanceof Dunno)
            return (object.toString().equals(this.toString()));
        return false;
    }
    @Override
    public void sleep(){
        super.sleep();
        System.out.println(this.toString() + " растянулся на дне отсека, подложив под голову вместо подушки свой собственный кулак");
    }
}