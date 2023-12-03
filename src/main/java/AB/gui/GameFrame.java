package AB.gui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

    GamePanel gamePanel;
    MenuPanel menuPanel;

    public GameFrame() {
        super("TrashMan");
        this.setSize(515, 590);
        this.setLocationRelativeTo(null); //odpalanie na srodku

        gamePanel = new GamePanel(500, 500);
        menuPanel = new MenuPanel();

        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(gamePanel);
        add(menuPanel);

        setVisible(true);
        gamePanel.startGameThread();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
