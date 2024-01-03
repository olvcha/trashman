package AB.gui;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MenuPanel extends JPanel {
    private JLabel levelLabel;
    @Getter
    private JLabel pointsLabel;
    @Getter
    private JButton menuButton;
    private JButton newGame;
    private JButton exit;
    private JButton gameButton;

    public MenuPanel(){
        setPreferredSize(new Dimension(500, 50));
        setLayout(new FlowLayout());
        createMenuSection();
        addActionListener();
    }

    /**
     * Creating menu section, including current level, points and menu button
     */
    private void createMenuSection(){
        levelLabel = new JLabel("Poziom:                    ");
        pointsLabel = new JLabel("Punkty:                   ");
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

    private void createMenuContent(){
        remove(levelLabel);
        remove(pointsLabel);
        remove(menuButton);

        this.repaint();
        newGame =  new JButton("New game");
        exit = new JButton("Exit");
        gameButton = new JButton("Game");
        //newGame.setPreferredSize(new Dimension(60, 20));

        newGame.setHorizontalAlignment(SwingConstants.CENTER);
        newGame.setVerticalAlignment(SwingConstants.CENTER);
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setVerticalAlignment(SwingConstants.CENTER);
        gameButton.setHorizontalAlignment(SwingConstants.CENTER);
        gameButton.setVerticalAlignment(SwingConstants.CENTER);

        Font centuryGothicFont = new Font("Century Gothic", Font.PLAIN, 18);
        newGame.setFont(centuryGothicFont);
        exit.setFont(centuryGothicFont);
        gameButton.setFont(centuryGothicFont);



        add(newGame);
        add(exit);
        add(gameButton);
        this.revalidate();
        this.repaint();
    }

    private void addActionListener(){
        menuButton.addActionListener(e -> {
            createMenuContent();
        });
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
