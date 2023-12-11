package aufgaben.remotecontroll.receiver;


import aufgaben.remotecontroll.receiver.util.OnOffSwitchable;

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
