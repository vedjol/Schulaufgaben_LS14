package aufgaben.remotecontroll_less_code.receiver;


import aufgaben.remotecontroll_less_code.receiver.util.OnOffSwitchable;

public class Light implements OnOffSwitchable {

    boolean light = false;


    public void switchOn() {
        light = true;
        System.out.println("Licht is turned on!");
    }

    public void switchOff() {
        light = false;
        System.out.println("Light is turned off!");
    }

}
