package AB.gui;

import javax.swing.*;
import java.awt.*;

import AB.GameElements.Player;
import com.formdev.flatlaf.FlatDarculaLaf;

public class GameFrame extends JFrame{

    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    private Player player;
    private long currentTime;

    /**
     * GameFrame class constructor
     */
    public GameFrame(Player player, long currentTime) {
        super("SuperKorok");
        this.player = player;
        this.currentTime = currentTime;
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            System.err.println("Failed to initialize theme. Using fallback.");
        }
        this.setSize(516, 590);
        //odpalanie na srodku

        menuPanel = new MenuPanel(this, player, currentTime);
        gamePanel = new GamePanel(500, 500, menuPanel, this, player, currentTime);

        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(gamePanel);
        add(menuPanel);

        setVisible(true);
        gamePanel.startGameThread();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
