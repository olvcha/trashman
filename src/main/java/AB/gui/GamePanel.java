package AB.gui;

import AB.GameElements.Player;
import AB.Mechanics.KeyHandler;
import AB.reading.Music;
import AB.reading.ResourceManager;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{
    private MenuPanel menuPanel;
    private Player player;
    private GameBoard gameBoard;
    private ResourceManager resourceManager;
    private int blockSize;
    private int width;
    private int height;
    private int blocksNumberInDirection;
    private int playerX = 20;
    private int playerY = 20;
    final int playerSpeed = 3;
    final int FPS = 60;
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Music music;

    public GamePanel(int width, int height, MenuPanel menuPanel){
        this.menuPanel = menuPanel;
        this.width = width;
        this.height = height;
        this.blocksNumberInDirection = 25;
        this.setPreferredSize(new Dimension(width, height));
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.gameBoard = new GameBoard();
        this.player = new Player();
        this.resourceManager = new ResourceManager();
        this.blockSize = width/this.blocksNumberInDirection; // width/25=20
        try {
            this.music = new Music();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
        music.play();
    }

    /**
     * Game loop
     */
    @Override
    public void run() {

        double drawInterval = (double) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;
            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }



    }

    /**
     * Updating the status of the game, information such as character position, checking collision with objects
     */
    public void update () {
        boolean collision = false;
        if (keyHandler.isUpPressed()) {
            int playerYindex = (playerY+15)/blockSize - 1;
            int playerXindex = (playerX+15)/blockSize;
            int playerPositionIndex = playerYindex * blocksNumberInDirection + playerXindex;
            if(gameBoard.getBoard().get(playerPositionIndex) != 'W'){
                playerY -= playerSpeed;
            }
            checkCollision(playerPositionIndex);
        }
        else if (keyHandler.isDownPressed()) {
            int playerYindex = playerY/blockSize + 1;
            int playerXindex = playerX/blockSize;
            int playerPositionIndex = playerYindex * blocksNumberInDirection + playerXindex;
            if(gameBoard.getBoard().get(playerPositionIndex) != 'W') {
                playerY += playerSpeed;
            }
            checkCollision(playerPositionIndex);
        }
        else if (keyHandler.isLeftPressed()) {
            int playerYindex = (playerY+15)/blockSize;
            int playerXindex = (playerX+15)/blockSize - 1;
            int playerPositionIndex = playerYindex * blocksNumberInDirection + playerXindex;
            if(gameBoard.getBoard().get(playerPositionIndex) != 'W') {
                playerX -= playerSpeed;
            }
            checkCollision(playerPositionIndex);
        }
        else if (keyHandler.isRightPressed()) {
            int playerYindex = playerY/blockSize;
            int playerXindex = playerX/blockSize + 1;
            int playerPositionIndex = playerYindex * blocksNumberInDirection + playerXindex;
            if(gameBoard.getBoard().get(playerPositionIndex) != 'W') {
                playerX += playerSpeed;
            }
            checkCollision(playerPositionIndex);
        }
    }

    private void checkCollision(int playerPositionIndex){
        if(gameBoard.getBoard().get(playerPositionIndex) == 'G'){
            gameBoard.getBoard().set(playerPositionIndex, 'N');
            player.increaseScore();
        }
        if(gameBoard.getBoard().get(playerPositionIndex) == 'P'){
            gameBoard.getBoard().set(playerPositionIndex, 'N');
            player.increaseScore();;
        }
        if(gameBoard.getBoard().get(playerPositionIndex) == 'B'){
            gameBoard.getBoard().set(playerPositionIndex, 'N');
            player.increaseScore();
        }
        menuPanel.getPointsLabel().setText("Points: " + player.getScore());
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //Painting board
        for (int height = 0; height < this.blocksNumberInDirection; height++){
            for (int width = 0; width < this.blocksNumberInDirection; width++){
                char block = gameBoard.getBoard().get(height * this.blocksNumberInDirection + width);
                switch(block){
                    case 'W':
                        g.drawImage(resourceManager.getWall(), width * this.blockSize, height * this.blockSize,
                    this);
                        break;
                    case 'N':
                        g.drawImage(resourceManager.getNothing(), width * this.blockSize, height * this.blockSize,
                                this);
                        break;
                    case 'G':
                        g.drawImage(resourceManager.getGlass(), width * this.blockSize, height * this.blockSize,
                                this);
                        break;
                    case 'P':
                        g.drawImage(resourceManager.getPlastic(), width * this.blockSize, height * this.blockSize,
                                this);
                        break;
                    case 'B':
                        g.drawImage(resourceManager.getPaper(), width * this.blockSize, height * this.blockSize,
                                this);
                        break;
                }
            }
        }

        //Painting character
        g.drawImage(resourceManager.getPlayer(),  playerX, playerY, this);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }


}

