package aufgaben.remotecontroll.gui.receivers;

import aufgaben.remotecontroll.receiver.Light;
import aufgaben.remotecontroll.receiver.util.observer.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LightPanel extends JPanel implements Observer {
    private static ImageIcon ON_ICON;
    private static ImageIcon OFF_ICON;
    private static final Color OFF_COLOR = new Color(120, 120, 120);
    private static final Color ON_COLOR = new Color(255, 185, 0);
    private final Light light;
    private JLabel isOnLabel;


    public LightPanel(Light light) {
        this.light = light;
        light.addObserver(this);
        initImages();
        initGUI();
        update();
    }

    private void initImages() {
        try {
            ON_ICON = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("images/light/On.png")));
            OFF_ICON = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("images/light/Off.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initGUI() {
        this.setLayout(new GridLayout(1, 0));
        isOnLabel = new JLabel();
        this.add(isOnLabel);
    }


    @Override
    public void update() {
        this.setBackground(light.isLightOn() ? ON_COLOR : OFF_COLOR);
        isOnLabel.setIcon(light.isLightOn() ? ON_ICON : OFF_ICON);
        repaint();
    }
}