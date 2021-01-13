package lab4.lib;

public enum Location {
    ELEVATOR("Лифт"),
    HALL("Корридор"),
    ROOM("Отсек"),
    ENTRANCE("Входной отсек"),
    KITCHEN("Пищевой отсек"),
    CONTROLROOM("Комната с кнопками");
    private final String name;
    Location(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
