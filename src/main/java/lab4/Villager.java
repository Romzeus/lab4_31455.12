package lab4;

import lab4.lib.Rocket;
import lab4.lib.Shorty;

public class Villager extends Shorty {
    public Villager() {
        super("Житель Лунного города");
    }
    @Override
    public void see(Object object) {
        System.out.print(this.toString());
        if (object instanceof Rocket){
            if (((Rocket) object).isFlightMode()) {
                System.out.print(" был бы очень удивлен, если");
            }
        }
        System.out.println(" увидел " + object.toString());
    }
}
