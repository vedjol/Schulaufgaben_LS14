package aufgaben.remotecontroll;

import aufgaben.remotecontroll.factory.RemoteControlFactory;
import aufgaben.remotecontroll.gui.remote.RemoteControl;

import javax.swing.*;

public class TestRemoteControll {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        RemoteControl r = RemoteControlFactory.createBasicRemote();
        f.add(r);
        f.pack();
        f.setVisible(true);
    }
}
