package AB;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class GameBoard {
    List<Character> board;

    public GameBoard(){
        board = new LinkedList<>();
    }

    public void readCSV() {
        ClassLoader classLoader = GameBoard.class.getClassLoader();
        String csvFilePath = classLoader.getResource("Map.csv").getPath();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            int c;
            while ((c = br.read()) != -1) {
                board.add((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
