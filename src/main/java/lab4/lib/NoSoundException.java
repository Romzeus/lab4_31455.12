package lab4.lib;

public class NoSoundException extends Exception {
    @Override
    public String toString() {
        return "Объект не издает звуков";
    }
}
