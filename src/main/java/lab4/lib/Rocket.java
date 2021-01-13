package lab4.lib;

public class Rocket {
    private boolean zeroGravity = false;
    private boolean flightMode = false;
    private final GravityDevice antigrav;
    private final Engine thrusters;
    public Rocket() {
        antigrav = new GravityDevice();
        thrusters = new Engine();
    }
    public class ControlMachine implements Controller, Interactable {
        @Override
        public void use() {
            switchGravity();
            switchEngine();
        }
        public void switchGravity() {
            Rocket.this.antigrav.switchDevice();
        }
        public void switchEngine() {
            if (flightMode)
                Rocket.this.thrusters.stopEngine();
            else
                Rocket.this.thrusters.startEngine();
        }
        @Override
        public String toString(){
            return "Электронная управляющая машина от " + Rocket.this.toString();
        }
    }
    private class GravityDevice {
        private void switchDevice() throws WrongRocketState {
            if (!flightMode) {
                Rocket.this.zeroGravity = !Rocket.this.zeroGravity;
                System.out.println("Невесомость " + (Rocket.this.zeroGravity ? " включена" : " отключена"));
            }
            else
                throw new WrongRocketState();
        }
    }
    private class Engine {
        private void startEngine() throws WrongRocketState {
            if (!Rocket.this.flightMode && Rocket.this.zeroGravity) {
                Rocket.this.flightMode = true;
                System.out.println("Двигатели включены");
            }
            else
                throw new WrongRocketState();
        }
        private void stopEngine() throws WrongRocketState{
            if (flightMode) {
                flightMode = false;
                System.out.println("Двигатели выключены");
            }
            else
                throw new WrongRocketState();
        }
    }
    @Override
    public String toString(){
        return "Ракета";
    }
    public boolean isFlightMode() {
        return flightMode;
    }
}

class WrongRocketState extends RuntimeException {
    @Override
    public String toString() {
        return "Попытка запуска/остановки работы двигателей/прибора невесомости при несовместимых состояниях ракеты";
    }
}