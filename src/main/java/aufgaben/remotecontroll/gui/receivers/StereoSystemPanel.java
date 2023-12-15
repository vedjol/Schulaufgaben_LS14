package aufgaben.remotecontroll.gui.receivers;

import aufgaben.remotecontroll.receiver.Light;
import aufgaben.remotecontroll.receiver.StereoSystem;
import aufgaben.remotecontroll.receiver.util.observer.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StereoSystemPanel extends JPanel implements Observer {
    private static ImageIcon PLAY_ICON;
    private static ImageIcon PAUSE_ICON;
    private static ImageIcon ON_ICON;
    private static ImageIcon OFF_ICON;
    private static final Color OFF_COLOR = new Color(120, 120, 120);
    private static final Color ON_COLOR = new Color(255, 255, 255);
    private final StereoSystem stereoSystem;
    private JLabel isOnLabel;
    private JLabel isRunningLabel;
    private JLabel volumeLabel;


    public StereoSystemPanel(StereoSystem stereoSystem) {
        this.stereoSystem = stereoSystem;
        stereoSystem.addObserver(this);
        initImages();
        initGUI();
        update();
    }

    private void initImages() {
        try {
            PLAY_ICON = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("images/stereo_system/Play.png")));
            PAUSE_ICON = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("images/stereo_system/Pause.png")));
            ON_ICON = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("images/stereo_system/On.png")));
            OFF_ICON = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("images/stereo_system/Off.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initGUI() {
        this.setLayout(new GridLayout(1, 0));
        isOnLabel = new JLabel();
        isRunningLabel = new JLabel();
        volumeLabel = new JLabel();
        this.add(isOnLabel);
        this.add(isRunningLabel);
        this.add(volumeLabel);
        update();
    }

    @Override
    public void update() {
        isOnLabel.setIcon(stereoSystem.isOn() ? ON_ICON : OFF_ICON);
        this.setBackground(stereoSystem.isOn() ? ON_COLOR : OFF_COLOR);
        isRunningLabel.setIcon(stereoSystem.isPlaying() ? PLAY_ICON : PAUSE_ICON);
        volumeLabel.setText("Volume: " + stereoSystem.getVolume());
        repaint();
    }
}