package aufgaben.remotecontroll.gui.remote;

import aufgaben.remotecontroll.command.util.Command;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RemoteControl extends JPanel {
    private static final int COLUMN_COUNT = 2;
    private static final int GAP = 5;
    private final Stack<Command> commandStack = new Stack<>();
    private final List<Command> commands;

    public RemoteControl(Command... commands) {
        this.commands = Arrays.asList(commands);
        initGUI();
    }

    private void initGUI() {
        this.setLayout(new GridLayout(0, COLUMN_COUNT, GAP, GAP));

        commands.stream().map(command -> {
            JButton b = new JButton(command.getName());
            b.addActionListener(a -> executeAction(commands.indexOf(command)));
            return b;
        }).forEach(this::add);

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(a -> pressUndoButton());
        this.add(undoButton);
    }

    private void executeAction(int index) {
        if (index < 0 || index >= commands.size())
            throw new IllegalArgumentException("The command you tried to execute could not be found!");
        Command c = commands.get(index);
        c.execute();
        commandStack.push(c);
    }

    public void pressUndoButton() {
        if (!commandStack.isEmpty()) commandStack.pop().undo();
    }
}
