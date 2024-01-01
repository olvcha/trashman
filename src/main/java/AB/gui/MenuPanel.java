package AB.gui;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MenuPanel extends JPanel {
    private JLabel levelLabel;
    @Getter
    private JLabel pointsLabel;
    private JButton menuButton;

    public MenuPanel(){
        setPreferredSize(new Dimension(500, 50));
        setLayout(new GridLayout(1, 3));
        createMenuSection();
    }

    /**
     * Creating menu section, including current level, points and menu button
     */
    private void createMenuSection(){
        levelLabel = new JLabel("Poziom: x");
        pointsLabel = new JLabel("Punkty: ");
        menuButton = new JButton("Menu");

        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        levelLabel.setVerticalAlignment(SwingConstants.CENTER);
        pointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pointsLabel.setVerticalAlignment(SwingConstants.CENTER);
        menuButton.setHorizontalAlignment(SwingConstants.CENTER);
        menuButton.setVerticalAlignment(SwingConstants.CENTER);

        Font centuryGothicFont = new Font("Century Gothic", Font.PLAIN, 18);
        levelLabel.setFont(centuryGothicFont);
        pointsLabel.setFont(centuryGothicFont);
        menuButton.setFont(centuryGothicFont);

        add(levelLabel);
        add(pointsLabel);
        add(menuButton);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 50);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D rectangle = new Rectangle2D.Double(0, 0, 500, 50);
        g2d.setColor(Color.white);
        g2d.fill(rectangle);
        // g2d.draw(rectangle);
    }


}
