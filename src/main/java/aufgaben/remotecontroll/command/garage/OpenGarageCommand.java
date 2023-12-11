package aufgaben.remotecontroll.command.garage;

import aufgaben.remotecontroll.command.util.Command;
import aufgaben.remotecontroll.receiver.Garage;

public class OpenGarageCommand implements Command {
    private Garage garage;

    public OpenGarageCommand(Garage garage) {
        setGarage(garage);
    }

    private void setGarage(Garage garage) {
        if (garage == null) throw new IllegalArgumentException("The garage should never be null");
        this.garage = garage;
    }


    @Override
    public void execute() {
        garage.open();
    }

    @Override
    public void undo() {
        garage.close();
    }
}
