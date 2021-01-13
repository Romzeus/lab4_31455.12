package lab4.lib;

public class Button implements Interactable{
    private final Interactable controlledObject;
    public Button(Interactable furniture){
        this.controlledObject = furniture;
    }
    public void use(){
        System.out.print("Кнопку нажали: ");
        this.controlledObject.use();
    }
    public Interactable getControlledObject() {
        return controlledObject;
    }
    @Override
    public String toString(){
        return "Кнопка от " + controlledObject.toString();
    }
    @Override
    public int hashCode(){
        return (controlledObject.hashCode() * 2);
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Button)
            return (((Button)obj).getControlledObject().equals(this.getControlledObject()));
        return false;
    }
}
