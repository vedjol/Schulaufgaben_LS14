package aufgaben.remotecontroll_less_code.command.universal;

import aufgaben.remotecontroll_less_code.command.stereosystem.StartPlayingStereoSystemCommand;
import aufgaben.remotecontroll_less_code.receiver.util.OnOffSwitchable;
import aufgaben.remotecontroll_less_code.command.util.Command;

public class SwitchOffCommand implements Command {

    SwitchOnCommand reverseCommand;

    public SwitchOffCommand(OnOffSwitchable switchable) {
        reverseCommand = new SwitchOnCommand(switchable);
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