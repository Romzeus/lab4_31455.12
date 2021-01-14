package lab4.lib;

public class Sound {
    public static String getSound(Object object) throws NoSoundException {
        String sound = " ";
        if (object instanceof Rocket)
            if (((Rocket) object).isFlightMode())
                sound = "мерный шум заработавшего ракетного двигателя";
        else if (object instanceof BetterShorty)
            if (((BetterShorty) object).isAsleep())
                sound = "мерное похрапывание";
        if (sound.equals(" "))
            throw new NoSoundException();
        else
            return sound;
    }
}