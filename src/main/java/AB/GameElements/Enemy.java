package AB.GameElements;

import AB.gui.GameBoard;
import AB.gui.GamePanel;
import AB.gui.MenuPanel;

import java.util.Random;

public class Enemy extends Character{
    private int direction;

    public Enemy(GameBoard gb, MenuPanel mp, GamePanel gp) {
        super(300,300,1, gb, mp, gp);
    }
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

    public int enemyPositionIndex(int coordinateXindex, int coordinateYindex){
        return coordinateYindex * gamePanel.getBlocksNumberInDirection() + coordinateXindex;
    }

    private void pickDirection(){
        Random random = new Random();
        int direction = this.direction;
        while(direction == this.direction){
            direction = random.nextInt(4);
        }
        this.direction = direction;
    }


}
