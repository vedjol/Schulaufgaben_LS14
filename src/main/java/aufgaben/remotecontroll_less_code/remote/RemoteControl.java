package aufgaben.remotecontroll_less_code.remote;

import aufgaben.remotecontroll_less_code.command.util.Command;

import java.util.Stack;

public class RemoteControl {

    private Stack<Command> commandStack = new Stack<>();
    private final Command[] buttons;

    public RemoteControl(Command... buttons) {
        this.buttons = buttons;
    }

    public void pressButton(int pos) {
        if (pos < 0 || pos >= buttons.length)
            throw new IllegalArgumentException("The Button you tried to press could not be found!");
        Command c = buttons[pos];
        c.execute();
        commandStack.push(c);
    }

    public void pressUndoButton() {
        if (!commandStack.isEmpty()) {
            commandStack.pop().undo();
        }
    }
}
