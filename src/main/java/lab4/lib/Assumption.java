package lab4.lib;

public class Assumption implements Thinkable{
    private Thought condition;
    private Thought statement;
    public Assumption(Thought condition, Thought statement) {
        this.condition = condition;
        this.statement = statement;
    }
    @Override
    public String getThought() {
        return "Если " + condition.getThought() + ", то " + statement.getThought();
    }
    public void assume() {
        System.out.println(getThought());
    }
    @Override
    public String toString() {
        return "Предположение о том, что " + getThought();
    }
}
