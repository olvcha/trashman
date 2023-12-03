package AB;

import AB.gui.GameBoard;
import AB.gui.GameFrame;

import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

       // new GameFrame();
        EventQueue.invokeLater(GameFrame::new);
        GameBoard board = new GameBoard();

    }
}