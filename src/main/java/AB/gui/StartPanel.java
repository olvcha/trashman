package AB.gui;

import AB.reading.ImagePanel;
import AB.reading.ResourceManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartPanel extends JPanel {
    private JFrame frame;
    private JButton startButton;
    private JLabel mainTitleLabel;

    /**
     * StartPanel class constructor
     * @param frame main frame
     */
    public StartPanel(JFrame frame) {
        this.frame = frame;
        this.startButton = new JButton("Start");
        this.mainTitleLabel = new JLabel("Game menu");
        //this.setLayout(new FlowLayout(FlowLayout.CENTER));
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(5, 3));

        initialize();

    }

    /**
     * Initializing content of the start panel such as main ttle, start button
     */
    private void initialize() {
        this.mainTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.mainTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.mainTitleLabel.setFont(new Font("Century Gothic", Font.PLAIN, 50));

        this.startButton.setPreferredSize(new Dimension(200, 100));
        this.startButton.setMaximumSize(new Dimension(100, 50));
        this.startButton.setFocusable(false);

        this.add(this.mainTitleLabel);
        this.add(this.startButton);

        addListener();

    }

    /**
     * Action listener for start button from method initialize(), it disposes current frame and starts a new game
     */
    private void addListener() {
        this.startButton.addActionListener(e -> {
            frame.dispose();
            GameFrame gameFrame = new GameFrame();
        });
    }


}
