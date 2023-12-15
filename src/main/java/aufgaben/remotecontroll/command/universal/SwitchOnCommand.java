package aufgaben.remotecontroll.command.universal;

import aufgaben.remotecontroll.command.util.Command;
import aufgaben.remotecontroll.receiver.util.OnOffSwitchable;

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
    public String getName() {
        return "Switch " + switchable.getClass().getSimpleName() + " on";
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
