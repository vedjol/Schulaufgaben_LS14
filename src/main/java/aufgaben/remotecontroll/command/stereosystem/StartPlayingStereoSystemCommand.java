package aufgaben.remotecontroll.command.stereosystem;

import aufgaben.remotecontroll.command.util.Command;
import aufgaben.remotecontroll.receiver.StereoSystem;

public class StartPlayingStereoSystemCommand implements Command {

    private StereoSystem stereoSystem;

    public StartPlayingStereoSystemCommand(StereoSystem stereoSystem) {
        setStereoSystem(stereoSystem);
    }

    private void setStereoSystem(StereoSystem stereoSystem) {
        if (stereoSystem == null) throw new IllegalArgumentException("The stereo system should never be null");
        this.stereoSystem = stereoSystem;
    }

    @Override
    public void execute() {
        stereoSystem.startPlaying();
    }

    @Override
    public void undo() {
        stereoSystem.stopPlaying();
    }
}
