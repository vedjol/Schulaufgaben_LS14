package aufgaben.remotecontroll_less_code.command.stereosystem;

import aufgaben.remotecontroll_less_code.command.garage.OpenGarageCommand;
import aufgaben.remotecontroll_less_code.receiver.Garage;
import aufgaben.remotecontroll_less_code.receiver.StereoSystem;
import aufgaben.remotecontroll_less_code.command.util.Command;

public class StopPlayingStereoSystemCommand implements Command {

    StartPlayingStereoSystemCommand reverseCommand;

    public StopPlayingStereoSystemCommand(StereoSystem stereoSystem) {
        reverseCommand = new StartPlayingStereoSystemCommand(stereoSystem);
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