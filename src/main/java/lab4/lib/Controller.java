package lab4.lib;

public interface Controller {
    default void interact(Interactable A) {
        A.use();
    }
}
