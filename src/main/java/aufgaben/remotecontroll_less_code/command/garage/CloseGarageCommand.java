package aufgaben.remotecontroll_less_code.command.garage;

import aufgaben.remotecontroll_less_code.command.util.Command;
import aufgaben.remotecontroll_less_code.receiver.Garage;

public class CloseGarageCommand implements Command {
    OpenGarageCommand reverseCommand;

    public CloseGarageCommand(Garage garage) {
        reverseCommand = new OpenGarageCommand(garage);
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
