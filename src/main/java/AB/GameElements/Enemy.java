package AB.GameElements;

import AB.gui.GameBoard;
import AB.gui.GamePanel;
import AB.gui.MenuPanel;

import java.util.Random;

public class Enemy extends Character{
    private int direction;

    /**
     * Enemy class constructor
     * @param gameBoard game board
     * @param menuPanel menu panel
     * @param gamePanel game panel
     */
    public Enemy(GameBoard gameBoard, MenuPanel menuPanel, GamePanel gamePanel) {
        super(300,300,1, gameBoard, menuPanel, gamePanel);
    }

    /**
     * Updating the current position of the enemy
     */
    public void update (){
        if(direction == 0){
            moveUp();
        }
        if(direction == 1){
            moveDown();
        }
        if(direction == 2){
            moveLeft();
        }
        if(direction == 3){
            moveRight();
        }
    }

    /**
     * Enemy's move up
     */
    public void moveUp(){
        int coordinateYindex = (coordinateY+15)/gamePanel.getBlockSize() - 1;
        int coordinateXindex = (coordinateX+15)/gamePanel.getBlockSize();
        int enemyPositionIndex = enemyPositionIndex(coordinateXindex, coordinateYindex);
        if(gameBoard.getBoard().get(enemyPositionIndex) != 'W'){
            coordinateY -= speed;
        }
        else{
            pickDirection();
        }
    }
    /**
     * Enemy's move down
     */
    public void moveDown(){
        int coordinateYindex = coordinateY/gamePanel.getBlockSize() + 1;
        int coordinateXindex = coordinateX/gamePanel.getBlockSize();
        int enemyPositionIndex = enemyPositionIndex(coordinateXindex, coordinateYindex);
        if(gameBoard.getBoard().get(enemyPositionIndex) != 'W') {
            coordinateY += speed;
        }
        else{
            pickDirection();
        }
    }
    /**
     * Enemy's move left
     */
    public void moveLeft(){
        int coordinateYindex = (coordinateY+15)/gamePanel.getBlockSize();
        int coordinateXindex = (coordinateX+15)/gamePanel.getBlockSize() - 1;
        int enemyPositionIndex = enemyPositionIndex(coordinateXindex, coordinateYindex);
        if(gameBoard.getBoard().get(enemyPositionIndex) != 'W') {
            coordinateX -= speed;
        }
        else{
            pickDirection();
        }
    }
    /**
     * Enemy's move right
     */
    public void moveRight(){
        int coordinateYindex = coordinateY/gamePanel.getBlockSize();
        int coordinateXindex = coordinateX/gamePanel.getBlockSize() + 1;
        int enemyPositionIndex = enemyPositionIndex(coordinateXindex, coordinateYindex);
        if(gameBoard.getBoard().get(enemyPositionIndex) != 'W') {
            coordinateX += speed;
        }
        else{
            pickDirection();
        }
    }

    /**
     * Calculating enemy's position index
     * @param coordinateXindex coordinate X index
     * @param coordinateYindex coordinate Y index
     * @return enemy position index
     */

    public int enemyPositionIndex(int coordinateXindex, int coordinateYindex){
        return coordinateYindex * gamePanel.getBlocksNumberInDirection() + coordinateXindex;
    }

    /**
     * Picking enemy's next move direction, it happens randomly
     */
    private void pickDirection(){
        Random random = new Random();
        int direction = this.direction;
        while(direction == this.direction){
            direction = random.nextInt(4);
        }
        this.direction = direction;
    }


}
