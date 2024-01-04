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
    private JLabel nothing;

    public StartPanel(JFrame frame) {
        this.frame = frame;
        this.startButton = new JButton("Start");
        this.mainTitleLabel = new JLabel("Game menu");
        this.nothing = new JLabel("");
        //this.setLayout(new FlowLayout(FlowLayout.CENTER));
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new GridLayout(5, 3));

        initialize();

    }

    private void initialize() {
        this.mainTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.mainTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.mainTitleLabel.setFont(new Font("Century Gothic", Font.PLAIN, 50));

        this.startButton.setPreferredSize(new Dimension(200, 100));
        this.startButton.setMaximumSize(new Dimension(100, 50));
        this.startButton.setFocusable(false);

        //this.add(this.nothing);
        this.add(this.mainTitleLabel);
        //this.add(this.nothing);

        //this.add(this.nothing);
        this.add(this.startButton);
        //this.add(this.nothing);


        addListener();

    }

    private void addListener() {
        this.startButton.addActionListener(e -> {
            frame.dispose();
            GameFrame gameFrame = new GameFrame();
        });
    }


}
