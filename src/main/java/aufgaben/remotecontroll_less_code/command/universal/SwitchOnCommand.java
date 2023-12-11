package aufgaben.remotecontroll_less_code.command.universal;

import aufgaben.remotecontroll_less_code.receiver.util.OnOffSwitchable;
import aufgaben.remotecontroll_less_code.command.util.Command;

public class SwitchOnCommand implements Command {
    private OnOffSwitchable switchable;

    public SwitchOnCommand(OnOffSwitchable switchable) {
        setSwitchable(switchable);
    }

    private void setSwitchable(OnOffSwitchable switchable) {
        if (switchable == null) throw new IllegalArgumentException("The light should never be null");
        this.switchable = switchable;
    }


    @Override
    public void execute() {
        switchable.switchOn();
    }

    @Override
    public void undo() {
        switchable.switchOff();
    }
}
