package AB.GameElements;

import AB.gui.GameBoard;
import AB.gui.GamePanel;
import AB.gui.MenuPanel;

public class Character {
    GameBoard gameBoard;
    GamePanel gamePanel; // null
    MenuPanel menuPanel;
    protected int coordinateX;
    protected int coordinateY;
    protected int speed;


    /**
     * Character class constructor
     * @param coordinateX x coordinate
     * @param coordinateY y coordinate
     * @param speed character's speed
     * @param gameBoard gameBoard
     * @param menuPanel menuPanel
     * @param gamePanel gamePanel
     */
    public Character(int coordinateX, int coordinateY, int speed, GameBoard gameBoard, MenuPanel menuPanel,
                     GamePanel gamePanel){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.speed = speed;
        this.gameBoard = gameBoard;
        this.menuPanel = menuPanel;
        this.gamePanel = gamePanel;
    }

    public Character(int coordinateX, int coordinateY, int speed){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.speed = speed;
    }
    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

}
