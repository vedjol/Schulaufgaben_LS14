package aufgaben.remotecontroll_less_code.command.universal;

import aufgaben.remotecontroll_less_code.receiver.util.SoundChangeable;
import aufgaben.remotecontroll_less_code.command.util.Command;

public class VolumeUpCommand implements Command {

    private SoundChangeable soundChangeable;

    public VolumeUpCommand(SoundChangeable soundChangeable) {
        setSoundChangeable(soundChangeable);
    }

    private void setSoundChangeable(SoundChangeable soundChangeable) {
        if (soundChangeable == null)
            throw new IllegalArgumentException("The oundchangable object should never be null");
        this.soundChangeable = soundChangeable;
    }

    @Override
    public void execute() {
        soundChangeable.setVolume(soundChangeable.getVolume() + 1);
    }

    @Override
    public void undo() {
        soundChangeable.setVolume(soundChangeable.getVolume() - 1);
    }
}
