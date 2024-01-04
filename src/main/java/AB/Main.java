package AB;

import AB.gui.GameBoard;
import AB.gui.GameFrame;
import AB.gui.StartFrame;
import AB.gui.StartPanel;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        SwingUtilities.invokeLater(StartFrame::new);
        //StartPanel startPanel = new StartPanel(StartFrame);
       //GameFrame gameFrame =  new GameFrame();

    }
}