package aufgaben.remotecontroll_less_code;

import aufgaben.remotecontroll_less_code.factory.RemoteControlFactory;
import aufgaben.remotecontroll_less_code.remote.RemoteControl;

public class TestRemoteControll {
    public static void main(String[] args) {
        RemoteControl r = RemoteControlFactory.createBasicRemote();

        r.pressButton(0);
        //...
    }
}
