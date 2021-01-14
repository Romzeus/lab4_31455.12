package lab4.lib;

public class WrongCondition extends RuntimeException {
    private String objectName;
    public WrongCondition(String objectName) {
        this.objectName = objectName;
    }
    @Override
    public String toString() {
        return objectName + " не может это делать в текущем состоянии";
    }
}
