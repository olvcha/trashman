package AB.gui;

import AB.GameElements.Player;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import AB.gui.GameFrame;

public class MenuPanel extends JPanel {
   private JFrame frame;
   private CardLayout cardLayout;
   private JPanel cardPanel;
    private JLabel levelLabel;
    private JLabel timeLabel;
    @Getter
    private JLabel pointsLabel;
    @Getter
    private JButton menuButton;
    private JButton newGame;
    private JButton exit;
    private JButton gameButton;
    private Player player;
    private long startTime;
    private long elapsedSeconds = 0;
    private long secondsDisplay = 0;
    private long elapsedMinutes = 0;
    private long minutesDisplay = 0;

    /**
     * MenuPanel class constructor
     * @param frame game frame
     */
    public MenuPanel(JFrame frame, Player player, long startTime){
        this.player = player;
        this.startTime = startTime;
        this.frame = frame;
        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        setPreferredSize(new Dimension(500, 50));
        setLayout(new FlowLayout());

        createMenuSection();
        createMenuContent();

        addActionListener();

        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
    }

    /**
     * Creating menu section, including current level, points and menu button
     */
    private void createMenuSection(){
        JPanel menuSection = new JPanel();

        this.levelLabel = new JLabel("Time:                    ");
        this.timeLabel = new JLabel("Time:                    ");
        this.pointsLabel = new JLabel("Points:                   ");
        this.menuButton = new JButton("Menu");

        this.levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.levelLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.pointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.pointsLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.menuButton.setHorizontalAlignment(SwingConstants.CENTER);
        this.menuButton.setVerticalAlignment(SwingConstants.CENTER);

        Font centuryGothicFont = new Font("Century Gothic", Font.PLAIN, 18);
        this.levelLabel.setFont(centuryGothicFont);
        this.pointsLabel.setFont(centuryGothicFont);
        this.menuButton.setFont(centuryGothicFont);;

        menuSection.add(levelLabel);
        menuSection.add(pointsLabel);
        menuSection.add(menuButton);

        cardPanel.add(menuSection, "MenuSection");
    }

    /**
     * Creating menu content which displays after pressing button "Menu" from menu section
     */
    private void createMenuContent(){
        JPanel menuContent = new JPanel();

        newGame =  new JButton("New game");
        exit = new JButton("Exit");
        gameButton = new JButton("Back to game");
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

        newGame.addActionListener(e -> {

            this.frame.dispose();
            new GameFrame(player, startTime);
        });

        exit.addActionListener(e -> {
            this.frame.dispose();
        });

        gameButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "MenuSection");
        });

        menuContent.add(newGame);
        menuContent.add(exit);
        menuContent.add(gameButton);

        cardPanel.add(menuContent, "MenuContent");

    }

    /**
     * Action listener for menu button from method createMenuSection, it changes currently displayed menu panel
     */
    private void addActionListener(){
        menuButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "MenuContent");
        });

    }

    /**
     * Getting preferred size of the panel
     * @return dimension
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 50);
    }

    public void setTime(long time){
        elapsedSeconds = time / 1000;
        secondsDisplay = elapsedSeconds % 60;
        elapsedMinutes = elapsedSeconds / 60;
        minutesDisplay = elapsedMinutes % 60;
        if(secondsDisplay < 10){
            this.levelLabel.setText("Time: " + minutesDisplay + ":0" + secondsDisplay + "              ");
        }
        else{
            this.levelLabel.setText("Time: " + minutesDisplay + ":" + secondsDisplay + "              ");
        }

    }



}
