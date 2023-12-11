package aufgaben.remotecontroll_less_code.command.universal;

import aufgaben.remotecontroll_less_code.receiver.util.SoundChangeable;
import aufgaben.remotecontroll_less_code.command.util.Command;

public class VolumeDownCommand implements Command {
    VolumeUpCommand reverseCommand;

    public VolumeDownCommand(SoundChangeable soundChangeable) {
        VolumeUpCommand reverseCommand = new VolumeUpCommand(soundChangeable);
    }

    @Override
    public void execute() {
        reverseCommand.undo();
    }

    @Override
    public void undo() {
        reverseCommand.execute();
    }
}