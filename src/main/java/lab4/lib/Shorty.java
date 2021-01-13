package lab4.lib;

public abstract class Shorty{
    private final String name;
    Shorty(String name){
        this.name = name;
    }
    public abstract void see(Object A);
    @Override
    public String toString(){
        return name;
    }
    @Override
    public int hashCode(){
        return (name.hashCode() * 2);
    }
}
