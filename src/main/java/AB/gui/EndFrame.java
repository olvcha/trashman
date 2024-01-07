package AB.gui;

import javax.swing.*;
import java.awt.*;

import AB.GameElements.Player;
import com.formdev.flatlaf.FlatDarculaLaf;

public class EndFrame extends JFrame{

    /**
     * GameFrame class constructor
     */
    public EndFrame(long time, int points) {
        super("SuperKorok");
        this.setSize(516, 590);
        this.setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            System.err.println("Failed to initialize theme. Using fallback.");
        }
        EndPanel panel = new EndPanel(time, points);



        this.add(panel);

        this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
