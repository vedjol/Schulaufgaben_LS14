package aufgaben.remotecontroll.gui.receivers;

import aufgaben.remotecontroll.receiver.Garage;
import aufgaben.remotecontroll.receiver.util.observer.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GaragePanel extends JPanel implements Observer {
    private static ImageIcon OPEN_ICON;
    private static ImageIcon CLOSE_ICON;
    private static final Color CLOSED_COLOR = new Color(120, 120, 120);
    private static final Color OPEN_COLOR = new Color(255, 255, 255);
    private final Garage garage;
    private JLabel isOpenedLabel;

    public GaragePanel(Garage g) {
        this.garage = g;
        garage.addObserver(this);
        initImages();
        initGUI();
        update();
    }

    private void initImages() {
        try {
            OPEN_ICON = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("images/garage/Opened.png")));
            CLOSE_ICON = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("images/garage/Closed.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initGUI() {
        this.setLayout(new GridLayout(1, 0));
        isOpenedLabel = new JLabel();
        this.add(isOpenedLabel);
    }

    @Override
    public void update() {
        this.setBackground(garage.isOpened() ? OPEN_COLOR : CLOSED_COLOR);
        isOpenedLabel.setIcon(garage.isOpened() ? OPEN_ICON : CLOSE_ICON);
        repaint();
    }
}
