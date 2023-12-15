package aufgaben.remotecontroll.command.universal;

import aufgaben.remotecontroll.command.util.Command;
import aufgaben.remotecontroll.receiver.util.OnOffSwitchable;

public class SwitchOffCommand implements Command {
    private OnOffSwitchable switchable;

    public SwitchOffCommand(OnOffSwitchable switchable) {
        setSwitchable(switchable);
    }

    private void setSwitchable(OnOffSwitchable switchable) {
        if (switchable == null) throw new IllegalArgumentException("The light should never be null");
        this.switchable = switchable;
    }


    @Override
    public String getName() {
        return "Switch " + switchable.getClass().getSimpleName() + " off";
    }

    @Override
    public void execute() {
        switchable.switchOff();
    }

    @Override
    public void undo() {
        switchable.switchOn();
    }
}