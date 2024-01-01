package AB.reading;

import AB.gui.GameBoard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CsvReader {

    /**
     * Reading csv file, returning game board
     * @param resource
     * @return
     */
    public List<Character> readCSV(String resource) {
        ClassLoader classLoader = GameBoard.class.getClassLoader();
        String csvFilePath = classLoader.getResource(resource).getPath();
        List<Character> board = new LinkedList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {

                String[] row = line.split(";");

                for(String singleChar : row) {
                    board.add(singleChar.charAt(0));
                }

            }
            return board;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
