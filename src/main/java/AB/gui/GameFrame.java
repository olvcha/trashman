package AB.gui;

import javax.swing.*;
import java.awt.*;

import AB.GameElements.Player;
import com.formdev.flatlaf.FlatDarculaLaf;

public class GameFrame extends JFrame{

    GamePanel gamePanel;
    MenuPanel menuPanel;
    Player player;

    /**
     * GameFrame class constructor
     */
    public GameFrame(Player player) {
        super("SuperKorok");
        this.player = player;
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            System.err.println("Failed to initialize theme. Using fallback.");
        }
        this.setSize(516, 590);
        this.setLocationRelativeTo(null); //odpalanie na srodku

        menuPanel = new MenuPanel(this, player);
        gamePanel = new GamePanel(500, 500, menuPanel, this, player);

        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(gamePanel);
        add(menuPanel);

        setVisible(true);
        gamePanel.startGameThread();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
