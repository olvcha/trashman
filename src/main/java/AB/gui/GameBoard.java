package AB.gui;

import AB.reading.CsvReader;

import java.util.LinkedList;
import java.util.List;

public class GameBoard {
    private List<Character> boardA;
    private List<Character> boardP;
    private List<Character> boardG;
    private List<Character> boardB;
    private List<List<Character>> boards;
    private char currentMap;
    private CsvReader csvReader;

    /**
     * Creating game board using csv file
     */
    public GameBoard(){
        this.boardA = new LinkedList<>();
        this.boardP = new LinkedList<>();
        this.boardG = new LinkedList<>();
        this.boardB = new LinkedList<>();
        this.boards = new LinkedList<>();

        this.csvReader = new CsvReader();
        this.currentMap = 'A';
        this.boardA = csvReader.readCSV("maps/MapTrashA.csv");
        this.boardP = csvReader.readCSV("maps/MapTrashP.csv");
        this.boardG = csvReader.readCSV("maps/MapTrashG.csv");
        this.boardB = csvReader.readCSV("maps/MapTrashB.csv");

        this.boards.add(boardA);
        this.boards.add(boardP);
        this.boards.add(boardG);
        this.boards.add(boardB);
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
            case 'B': {
                return boardB;
            }
            default: {
                return null;
            }
        }
    }

    /**
     * Getting amount of trash of a specific type
     * @param trashType type of trash: A - all, P - plastic, G - glass, B - paper
     * @return amount of trash
     */
    public int getTrashAmount(char trashType, List<Character> board){
        int amount = 0;
        for (char block:board) {
            if(trashType == 'A'){
                if (block == 'G' || block == 'B' || block == 'P') {
                    amount += 1;
                }
            }
            else if (block == trashType){
                amount += 1;
            }
        }
        return amount;
    }

    public char getCurrentMap() {
        return currentMap;
    }

    public List<Character> getBoardA() {
        return boardA;
    }

    public void setCurrentMap(char currentMap) {
        this.currentMap = currentMap;
    }

    public List<List<Character>> getBoards() {
        return boards;
    }
}
