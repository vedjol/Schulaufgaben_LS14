package aufgaben.remotecontroll;

import aufgaben.remotecontroll.factory.RemoteControlFactory;
import aufgaben.remotecontroll.remote.RemoteControl;

public class TestRemoteControll {
    public static void main(String[] args) {
        RemoteControl r = RemoteControlFactory.createBasicRemote();

        r.pressButton(0);
        //...
    }
}
