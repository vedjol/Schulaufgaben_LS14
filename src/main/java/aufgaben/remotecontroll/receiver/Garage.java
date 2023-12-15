package aufgaben.remotecontroll.receiver;

import aufgaben.remotecontroll.receiver.util.observer.Subject;

public class Garage extends Subject {

    private boolean opened;

    public boolean isOpened() {
        return opened;
    }

    public void open() {
        System.out.println("Garagentor is getting opened");
        this.opened = true;
        notifyObservers();
    }

    public void close() {
        System.out.println("Garagentor is getting closed");
        this.opened = false;
        notifyObservers();
    }

}
