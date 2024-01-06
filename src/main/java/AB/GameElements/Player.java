package AB.GameElements;
import AB.Mechanics.KeyHandler;
import AB.gui.GameBoard;
import AB.gui.GamePanel;
import AB.gui.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class Player extends Character{
    private int score = 0;
    private int hearts = 3;
    private int trashCollected = 0;

    public Player(GameBoard gb, MenuPanel mp, GamePanel gp) {
        super(20,20,2, gb, mp, gp);
    }

    public void moveUp(){
        int coordinateYindex = (coordinateY+15)/gamePanel.getBlockSize() - 1;
        int coordinateXindex = (coordinateX+15)/gamePanel.getBlockSize();
        int playerPositionIndex = playerPositionIndex(coordinateXindex, coordinateYindex);
        if(gameBoard.getBoard().get(playerPositionIndex) != 'W'){
            coordinateY -= speed;
        }
        checkCollisionWithTrash(playerPositionIndex);
    }

    public void moveDown(){
        int coordinateYindex = (coordinateY)/gamePanel.getBlockSize() + 1;
        int coordinateXindex = (coordinateX)/gamePanel.getBlockSize();
        int playerPositionIndex = playerPositionIndex(coordinateXindex, coordinateYindex);
        if(gameBoard.getBoard().get(playerPositionIndex) != 'W') {
            coordinateY += speed;
        }
        checkCollisionWithTrash(playerPositionIndex);
    }

    public void moveLeft(){
        int coordinateYindex = (coordinateY+15)/gamePanel.getBlockSize();
        int coordinateXindex = (coordinateX+15)/gamePanel.getBlockSize() - 1;
        int playerPositionIndex = playerPositionIndex(coordinateXindex, coordinateYindex);
        if(gameBoard.getBoard().get(playerPositionIndex) != 'W') {
            coordinateX -= speed;
        }
        checkCollisionWithTrash(playerPositionIndex);
    }

    public void moveRight(){
            int coordinateYindex = (coordinateY)/gamePanel.getBlockSize();
            int coordinateXindex = (coordinateX)/gamePanel.getBlockSize() + 1;
            int playerPositionIndex = playerPositionIndex(coordinateXindex, coordinateYindex);
            if(gameBoard.getBoard().get(playerPositionIndex) != 'W') {
                coordinateX += speed;
            }
            checkCollisionWithTrash(playerPositionIndex);
    }
    public int playerPositionIndex(int coordinateXindex, int coordinateYindex){
        return coordinateYindex * gamePanel.getBlocksNumberInDirection() + coordinateXindex;
    }

    private void checkCollisionWithTrash(int playerPositionIndex){
        char currentMap = gameBoard.getCurrentMap();
        if(currentMap == 'A') {
            if (gameBoard.getBoard().get(playerPositionIndex) == 'G'
                    || gameBoard.getBoard().get(playerPositionIndex) == 'P'
                    || gameBoard.getBoard().get(playerPositionIndex) == 'B') {
                gameBoard.getBoard().set(playerPositionIndex, 'N');
                increaseScore();
                trashCollected += 1;
            }
        }
        if(currentMap == 'G') {
            if (gameBoard.getBoard().get(playerPositionIndex) == 'G') {
                gameBoard.getBoard().set(playerPositionIndex, 'N');
                increaseScore();
                trashCollected += 1;
            }
        } else if(gameBoard.getBoard().get(playerPositionIndex) == 'P'
                || gameBoard.getBoard().get(playerPositionIndex) == 'B'){
            decreaseScore();
        }

        if(currentMap == 'P') {
            if (gameBoard.getBoard().get(playerPositionIndex) == 'P') {
                gameBoard.getBoard().set(playerPositionIndex, 'N');
                increaseScore();
                trashCollected += 1;
            }
        } else if(gameBoard.getBoard().get(playerPositionIndex) == 'G'
                || gameBoard.getBoard().get(playerPositionIndex) == 'B'){
            decreaseScore();
        }

        if(currentMap == 'B') {
            if (gameBoard.getBoard().get(playerPositionIndex) == 'B') {
                gameBoard.getBoard().set(playerPositionIndex, 'N');
                increaseScore();
                trashCollected += 1;
            }
        } else if(gameBoard.getBoard().get(playerPositionIndex) == 'P'
                || gameBoard.getBoard().get(playerPositionIndex) == 'G'){
            decreaseScore();
        }
        menuPanel.getPointsLabel().setText("Points: " + getScore());
    }


    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }

    public int getHearts() {
        return hearts;
    }

    public void increaseScore(){
        this.score += 1;
    }
    public void decreaseScore(){
        this.score -= 1;
    }
    public void decreaseHearts(){
        this.hearts -= 1;
    }

    public int getTrashCollected(){
        return trashCollected;
    }
}
