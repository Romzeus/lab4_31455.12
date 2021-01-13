package lab4.lib;

public interface Thinker {
    default public void think(Thought thought){
        System.out.println(this.toString() + "подумал: " + thought.getThought());
    }
}
