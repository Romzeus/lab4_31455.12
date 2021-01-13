package lab4.lib;

public enum FurnitureType {
    FRIDGE("холодильник"),
    TERMOSTAT("термостат"),
    LOCKER("шкаф");
    private final String naming;
    FurnitureType(String naming){this.naming = naming;}
    public String type(){
        return this.naming;
    }
}
