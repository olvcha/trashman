package AB.gui;

import AB.reading.CsvReader;

import java.util.LinkedList;
import java.util.List;

public class GameBoard {
    private List<Character> board;
    private CsvReader csvReader;

    /**
     * Creating game board using csv file
     */
    public GameBoard(){
        board = new LinkedList<>();
        csvReader = new CsvReader();
        board = csvReader.readCSV("maps/MapTrash.csv");
    }

    /**
     * Displaying game board
     * @return
     */
    public List<Character> getBoard() {
        return board;
    }
}
