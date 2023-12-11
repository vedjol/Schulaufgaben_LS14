package aufgaben.remotecontroll_less_code.receiver;

public class Garage {

    private boolean opened;

    public boolean isOpened() {
        return opened;
    }

    public void open() {
        System.out.println("Garagentor is getting opened");
        this.opened = true;
    }

    public void close() {
        System.out.println("Garagentor is getting closed");
        this.opened = false;
    }

}
