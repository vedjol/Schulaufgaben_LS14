package aufgaben.remotecontroll.command.universal;

import aufgaben.remotecontroll.command.util.Command;
import aufgaben.remotecontroll.receiver.util.SoundChangeable;

public class VolumeDownCommand implements Command {

    private SoundChangeable soundChangeable;

    public VolumeDownCommand(SoundChangeable soundChangeable) {
        setSoundChangeable(soundChangeable);
    }

    private void setSoundChangeable(SoundChangeable soundChangeable) {
        if (soundChangeable == null)
            throw new IllegalArgumentException("The soundchangable object should never be null");
        this.soundChangeable = soundChangeable;
    }

    @Override
    public String getName() {
        return "Reduce " + soundChangeable.getClass().getSimpleName() + " volume";
    }

    @Override
    public void execute() {
        soundChangeable.setVolume(soundChangeable.getVolume() - 1);
    }

    @Override
    public void undo() {
        soundChangeable.setVolume(soundChangeable.getVolume() + 1);
    }
}