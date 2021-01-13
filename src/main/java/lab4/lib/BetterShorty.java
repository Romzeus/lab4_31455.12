package lab4.lib;

public abstract class BetterShorty extends Shorty implements Controller, SleepyHead{
    private boolean asleep = false;
    private Location currentLocation = Location.ENTRANCE;
    public BetterShorty(String name) {
        super(name);
    }
    public void move(Location location) {
        System.out.println(this.toString() + " выходит из " + currentLocation.getName());
        currentLocation = location;
        System.out.println(this.toString() + " входит в " + currentLocation.getName());
    }
    @Override
    public void sleep() throws WrongSleepCondition{
        if (!asleep)
            asleep = true;
        else
            throw new WrongSleepCondition(this.toString());
    }
    @Override
    public void wake() throws WrongSleepCondition{
        if (asleep)
            asleep = false;
        else
            throw new WrongSleepCondition(this.toString());
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

