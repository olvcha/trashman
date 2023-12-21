package AB.gui;

import AB.reading.CsvReader;

import java.util.LinkedList;
import java.util.List;

public class GameBoard {
    private List<Character> board;
    private CsvReader csvReader;

    public GameBoard(){
        board = new LinkedList<>();
        csvReader = new CsvReader();
        board = csvReader.readCSV("maps/Map.csv");
    }

    public List<Character> getBoard() {
        return board;
    }
}
