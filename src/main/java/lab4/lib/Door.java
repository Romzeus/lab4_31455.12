package lab4.lib;

public class Door extends Furniture{
    public Door(){
        super(true);
    }
    @Override
    public void use(){
        this.changeCondition();
        System.out.println(this.toString() + " " + (this.getCondition() ? "открыта" : "закрыта"));
    }
    @Override
    public int hashCode(){
        return (this.getCondition() ? 1 : 0);
    }
    @Override
    public String toString() {
        return "Дверь";
    }
    @Override
    public boolean equals(Object object) {
        if (object instanceof Door)
            return (((Door)object).getCondition() == this.getCondition());
        return false;
    }
}
