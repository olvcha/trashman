package AB.gui;

import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatDarculaLaf;

public class GameFrame extends JFrame{

    GamePanel gamePanel;
    MenuPanel menuPanel;

    /**
     * GameFrame class constructor
     */
    public GameFrame() {
        super("SuperKorok");
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            System.err.println("Failed to initialize theme. Using fallback.");
        }
        this.setSize(516, 590);
        this.setLocationRelativeTo(null); //odpalanie na srodku

        menuPanel = new MenuPanel(this);
        gamePanel = new GamePanel(500, 500, menuPanel);

        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(gamePanel);
        add(menuPanel);

        setVisible(true);
        gamePanel.startGameThread();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
