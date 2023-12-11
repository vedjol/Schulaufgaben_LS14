package aufgaben.remotecontroll.receiver;

import aufgaben.remotecontroll.receiver.util.OnOffSwitchable;
import aufgaben.remotecontroll.receiver.util.SoundChangeable;

public class StereoSystem implements OnOffSwitchable, SoundChangeable {

    private String cd;
    private boolean on;
    private boolean playing;
    private int volume;

    public void startPlaying() {
        this.playing = true;
        System.out.println("Started playing...");
    }

    public void stopPlaying() {
        this.playing = false;
        System.out.println("Stopped playing.");
    }

    public void switchOn() {
        this.on = true;
        System.out.println("The stereo system is now on.");
    }

    public void switchOff() {
        this.on = false;
        System.out.println("The stereo system is now off.");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Changing volume to " + volume + ".");
    }

    public int getVolume() {
        return this.volume;
    }

    public void setCD(String cdName) {
        this.cd = cdName;
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
