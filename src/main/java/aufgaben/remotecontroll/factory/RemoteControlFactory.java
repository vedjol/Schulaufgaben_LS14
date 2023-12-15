package aufgaben.remotecontroll.factory;

import aufgaben.remotecontroll.command.garage.CloseGarageCommand;
import aufgaben.remotecontroll.command.garage.OpenGarageCommand;
import aufgaben.remotecontroll.command.stereosystem.StartPlayingStereoSystemCommand;
import aufgaben.remotecontroll.command.stereosystem.StopPlayingStereoSystemCommand;
import aufgaben.remotecontroll.command.universal.SwitchOffCommand;
import aufgaben.remotecontroll.command.universal.SwitchOnCommand;
import aufgaben.remotecontroll.command.universal.VolumeDownCommand;
import aufgaben.remotecontroll.command.universal.VolumeUpCommand;
import aufgaben.remotecontroll.gui.remote.RemoteControl;
import aufgaben.remotecontroll.receiver.Garage;
import aufgaben.remotecontroll.receiver.Light;
import aufgaben.remotecontroll.receiver.StereoSystem;

public class RemoteControlFactory {

    public static RemoteControl createBasicRemote() {
        //init receiver...
        Garage garage = new Garage();
        Light light = new Light();
        StereoSystem stereoSystem = new StereoSystem();

        //init commands...
        //garage
        OpenGarageCommand openGarageCommand = new OpenGarageCommand(garage);
        CloseGarageCommand closeGarageCommand = new CloseGarageCommand(garage);
        //light
        SwitchOnCommand switchLightOnCommand = new SwitchOnCommand(light);
        SwitchOffCommand switchLightOffCommand = new SwitchOffCommand(light);
        //stereo system
        SwitchOnCommand switchStereoSystemOnCommand = new SwitchOnCommand(stereoSystem);
        SwitchOffCommand switchStereoSystemOffCommand = new SwitchOffCommand(stereoSystem);
        StartPlayingStereoSystemCommand startPlayingStereoSystemCommand = new StartPlayingStereoSystemCommand(stereoSystem);
        StopPlayingStereoSystemCommand stopPlayingStereoSystemCommand = new StopPlayingStereoSystemCommand(stereoSystem);
        VolumeUpCommand volumeUpCommand = new VolumeUpCommand(stereoSystem);
        VolumeDownCommand volumeDownCommand = new VolumeDownCommand(stereoSystem);

        //Add commands and return remote
        return new RemoteControl(
                openGarageCommand,
                closeGarageCommand,
                switchLightOnCommand,
                switchLightOffCommand,
                switchStereoSystemOnCommand,
                switchStereoSystemOffCommand,
                startPlayingStereoSystemCommand,
                stopPlayingStereoSystemCommand,
                volumeUpCommand,
                volumeDownCommand
        );
    }
}
