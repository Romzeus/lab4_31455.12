package lab4.lib;

public class Thought implements Thinkable{
    private final String thought;
    private final Difficulty difficulty;
    public Thought(String thought) {
        this.thought = thought;
        difficulty = Difficulty.NORMAL;
    }
    public Thought(String thought, Difficulty difficulty) {
        this.thought = thought;
        this.difficulty = difficulty;
    }
    public String getThought() {
        try {
            return formulateThought();
        } catch (NoThoughts noThoughts) {
            return noThoughts.toString();
        }
    }
    private String formulateThought() throws NoThoughts {
        if (!thought.equals(""))
            return thought;
        else
            throw new NoThoughts();
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
    @Override
    public String toString() {
        return "Мысль о том, что " + getThought();
    }
}

class NoThoughts extends Exception {
    @Override
    public String toString() {
        return "Отсутствует мысль";
    }
}