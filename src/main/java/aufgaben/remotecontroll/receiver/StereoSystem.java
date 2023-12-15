package aufgaben.remotecontroll.receiver;

import aufgaben.remotecontroll.receiver.util.OnOffSwitchable;
import aufgaben.remotecontroll.receiver.util.SoundChangeable;
import aufgaben.remotecontroll.receiver.util.observer.Subject;

public class StereoSystem extends Subject implements OnOffSwitchable, SoundChangeable {

    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 20;
    private String cd;
    private boolean on;
    private boolean playing;
    private int volume;

    public void startPlaying() {
        if (!isOn()) return;
        this.playing = true;
        System.out.println("Started playing...");
        notifyObservers();
    }

    public void stopPlaying() {
        this.playing = false;
        System.out.println("Stopped playing.");
        notifyObservers();
    }

    public boolean isPlaying() {
        return playing;
    }

    public void switchOn() {
        this.on = true;
        System.out.println("The stereo system is now on.");
        notifyObservers();
    }

    public void switchOff() {
        this.on = false;
        this.stopPlaying();
        System.out.println("The stereo system is now off.");
        notifyObservers();
    }

    public boolean isOn() {
        return on;
    }

    public void setVolume(int volume) {
        if (volume < MIN_VOLUME) {
            System.out.println("Volume " + volume + " is smaller than the lowest possible volume of " + MIN_VOLUME + " .");
            return;
        }
        if (volume > MAX_VOLUME) {
            System.out.println("Volume " + volume + " is higher than the maximum possible volume of " + MAX_VOLUME + ".");
            return;
        }
        this.volume = volume;
        System.out.println("Changing volume to " + volume + ".");
        notifyObservers();
    }

    public int getVolume() {
        return this.volume;
    }

    public void setCD(String cdName) {
        this.cd = cdName;
        notifyObservers();
    }

    public String getCD() {
        return this.cd;
    }


    public StereoSystem() {
        this.on = false;
        this.cd = new String("NO CD");
        this.volume = 4;
        this.playing = false;
    }

}
