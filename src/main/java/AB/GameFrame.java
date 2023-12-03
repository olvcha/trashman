package AB;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GameFrame extends JFrame{

    JPanel gamePanel;
    JPanel menuPanel;

    public GameFrame() {
        //JFrame frame = new JFrame("TrashMan");
        //frame.setSize(500, 500);
        super("TrashMan");
        this.setSize(510, 590);
        this.setLocationRelativeTo(null); //odpalanie na srodku

        gamePanel = new GamePanel();
        menuPanel = new MenuPanel();

        //JPanel containerPanel = new JPanel(new GridLayout(2, 1));
        //containerPanel.add(gamePanel);
        //containerPanel.add(menuPanel);
        //add(containerPanel);

        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(gamePanel);
        add(menuPanel);
        //pack();
        //this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
