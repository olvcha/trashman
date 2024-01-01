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

    public Character(int x, int y, int s, GameBoard gb, MenuPanel mp, GamePanel gp){
        this.coordinateX = x;
        this.coordinateY = y;
        this.speed = s;
        this.gameBoard = gb;
        this.menuPanel = mp;
        this.gamePanel = gp;

    }
    public void checkCollisionWithWall (){
        int coordinateYindex = (coordinateY+15)/gamePanel.getBlockSize() - 1;
        int coordinateXindex = (coordinateX+15)/gamePanel.getBlockSize();
        int characterPositionIndex = coordinateYindex * gamePanel.getBlocksNumberInDirection() + coordinateXindex;
        if(gameBoard.getBoard().get(characterPositionIndex) != 'W'){
            coordinateY -= speed;
        }
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
