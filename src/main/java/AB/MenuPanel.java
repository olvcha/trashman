package AB;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MenuPanel extends JPanel {

    public MenuPanel(){
        setPreferredSize(new Dimension(500, 50));
        setLayout(new GridLayout(1, 3));
        createMenuSection();
    }

    /**
     * shjishish
     */
    private void createMenuSection(){
        JLabel levelLabel = new JLabel("Poziom: x");
        JLabel pointsLabel = new JLabel("Punkty: x");
        JButton menuButton = new JButton("Menu");

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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D rectangle = new Rectangle2D.Double(0, 0, 500, 50);
        g2d.setColor(Color.white);
        g2d.fill(rectangle);
        // g2d.draw(rectangle);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 50);
    }


}
