package lab4.lib;

public class WrongSleepCondition extends Exception {
    private String name;
    WrongSleepCondition(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name + " уже спит/бодрствует";
    }
}
