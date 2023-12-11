package aufgaben.remotecontroll.factory;

import aufgaben.remotecontroll.command.garage.*;
import aufgaben.remotecontroll.command.stereosystem.StartPlayingStereoSystemCommand;
import aufgaben.remotecontroll.command.stereosystem.StopPlayingStereoSystemCommand;
import aufgaben.remotecontroll.command.universal.*;
import aufgaben.remotecontroll.receiver.*;
import aufgaben.remotecontroll.remote.*;

public class RemoteControlFactory {

    public static RemoteControl createBasicRemote() {
        //init receiver...
        Garage garage = new Garage();
        Light light = new Light();
        StereoSystem stereoSystem = new StereoSystem();

        //init commands...
        //garage
        CloseGarageCommand closeGarageCommand = new CloseGarageCommand(garage);
        OpenGarageCommand openGarageCommand = new OpenGarageCommand(garage);
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
        return new RemoteControl(closeGarageCommand,
                openGarageCommand,
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
