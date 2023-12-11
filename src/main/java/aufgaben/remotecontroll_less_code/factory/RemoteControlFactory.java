package aufgaben.remotecontroll_less_code.factory;

import aufgaben.remotecontroll_less_code.command.garage.CloseGarageCommand;
import aufgaben.remotecontroll_less_code.command.garage.OpenGarageCommand;
import aufgaben.remotecontroll_less_code.command.stereosystem.StartPlayingStereoSystemCommand;
import aufgaben.remotecontroll_less_code.command.stereosystem.StopPlayingStereoSystemCommand;
import aufgaben.remotecontroll_less_code.command.universal.SwitchOffCommand;
import aufgaben.remotecontroll_less_code.command.universal.SwitchOnCommand;
import aufgaben.remotecontroll_less_code.command.universal.VolumeDownCommand;
import aufgaben.remotecontroll_less_code.command.universal.VolumeUpCommand;
import aufgaben.remotecontroll_less_code.receiver.Garage;
import aufgaben.remotecontroll_less_code.receiver.Light;
import aufgaben.remotecontroll_less_code.receiver.StereoSystem;
import aufgaben.remotecontroll_less_code.remote.RemoteControl;

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
