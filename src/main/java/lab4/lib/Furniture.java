package lab4.lib;

public abstract class Furniture implements Interactable{
    private boolean openess;
    public Furniture(boolean condition){
        openess = condition;
    }
    public void changeCondition() {
        openess = !openess;
    }
    public boolean getCondition(){
        return openess;
    }
}
