package aufgaben.remotecontroll.command.util;

public interface Command {
    String getName();

    void execute();

    void undo();
}
