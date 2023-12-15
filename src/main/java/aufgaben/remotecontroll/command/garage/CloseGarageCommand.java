package aufgaben.remotecontroll.command.garage;

import aufgaben.remotecontroll.command.util.Command;
import aufgaben.remotecontroll.receiver.Garage;

public class CloseGarageCommand implements Command {
    private static final String STANDARD_NAME = "Close garage";
    private Garage garage;

    public CloseGarageCommand(Garage garage) {
        setGarage(garage);
    }

    private void setGarage(Garage garage) {
        if (garage == null) throw new IllegalArgumentException("The garage should never be null");
        this.garage = garage;
    }

    @Override
    public String getName() {
        return STANDARD_NAME;
    }
    @Override
    public void execute() {
        garage.close();
    }

    @Override
    public void undo() {
        garage.open();
    }
}
