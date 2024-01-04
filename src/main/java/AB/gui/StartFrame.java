package AB.gui;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class StartFrame extends JFrame {
    
    public StartFrame(){
        super("SuperKorok");
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            System.err.println("Failed to initialize theme. Using fallback.");
        }
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(516, 590);
        this.setLocationRelativeTo(null); //odpalanie na srodku

        initialize();

        this.setVisible(true);
        
    }
    
    private void initialize(){
        JPanel startPanel = new StartPanel(this);
        this.add(startPanel);
    }
}
