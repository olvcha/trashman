package AB.gui;

import AB.reading.CsvReader;

import java.util.LinkedList;
import java.util.List;

public class GameBoard {
    private List<Character> boardA;
    private List<Character> boardP;
    private List<Character> boardG;
    private List<Character> boardW;
    private char currentMap;
    private CsvReader csvReader;

    /**
     * Creating game board using csv file
     */
    public GameBoard(){
        this.boardA = new LinkedList<>();
        this.boardP = new LinkedList<>();
        this.boardG = new LinkedList<>();
        this.boardW = new LinkedList<>();
        this.csvReader = new CsvReader();
        this.currentMap = 'A';
        this.boardA = csvReader.readCSV("maps/MapTrashA.csv");
        this.boardP = csvReader.readCSV("maps/MapTrashP.csv");
        this.boardG = csvReader.readCSV("maps/MapTrashG.csv");
        this.boardW = csvReader.readCSV("maps/MapTrashW.csv");
    }

    /**
     * Displaying game board
     * @return appearance of the board
     */
    public List<Character> getBoard() {
        switch (currentMap) {
            case 'A': {
                return boardA;
            }
            case 'P': {
                return boardP;
            }
            case 'G': {
                return boardG;
            }
            case 'W': {
                return boardW;
            }
            default: {
                return null;
            }
        }
    }

    /**
     * Getting amount of trash of a specific type
     * @param trashType type of trash: A - all, P - plastic, G - glass, W - paper
     * @return amount of trash
     */
    private int getTrashAmount(char trashType, List<Character> board){
        int amount = 0;
        for (char block:board) {
            if (block == trashType){
                amount += 1;
            }
        }
        return amount;
    }
}
