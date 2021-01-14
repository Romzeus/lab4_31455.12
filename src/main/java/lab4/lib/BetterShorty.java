package lab4.lib;

public abstract class BetterShorty extends Shorty implements Controller{
    private boolean asleep = false;
    private Location currentLocation = Location.ENTRANCE;
    public BetterShorty(String name) {
        super(name);
    }
    public void move(Location location) {
        if (asleep)
            throw new WrongCondition(toString());
        System.out.println(this.toString() + " выходит из " + currentLocation.getName());
        currentLocation = location;
        System.out.println(this.toString() + " входит в " + currentLocation.getName());
    }
    public void sleep(){
        if (!asleep)
            asleep = true;
        else
            throw new WrongCondition(toString());
    }
    public void wake(){
        if (asleep)
            asleep = false;
        else
            throw new WrongCondition(toString());
    }
    public boolean isAsleep() {
        return asleep;
    }
    @Override
    public void interact(Interactable object){
        System.out.println(this.toString() + " использует " + object.toString());
        object.use();
    }
}
