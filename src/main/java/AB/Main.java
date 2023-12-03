package AB;

import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

       // new GameFrame();
        EventQueue.invokeLater(GameFrame::new);
        GameBoard board = new GameBoard();
        board.readCSV();
    }
}