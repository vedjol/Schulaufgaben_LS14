package aufgaben.remotecontroll.receiver;


import aufgaben.remotecontroll.receiver.util.OnOffSwitchable;
import aufgaben.remotecontroll.receiver.util.observer.Subject;

public class Light  extends Subject implements OnOffSwitchable {
    private boolean light = false;


    public void switchOn() {
        light = true;
        System.out.println("Licht is turned on!");
        notifyObservers();
    }

    public void switchOff() {
        light = false;
        System.out.println("Light is turned off!");
        notifyObservers();
    }

    public boolean isLightOn() {
        return light;
    }
}
