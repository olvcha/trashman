package AB.gui;

import AB.GameElements.Enemy;
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
    private Enemy enemy;
    private GameBoard gameBoard;
    private ResourceManager resourceManager;
    private int blockSize;
    private int width;
    private int height;
    private int blocksNumberInDirection;
    final int FPS = 60;
    private KeyHandler keyHandler = new KeyHandler();
    private Thread gameThread;
    private Music music;

    public GamePanel(int width, int height, MenuPanel menuPanel){
        this.menuPanel = menuPanel;
        this.width = width;
        this.height = height;
        this.blocksNumberInDirection = 25;
        this.setPreferredSize(new Dimension(width, height));
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.gameBoard = new GameBoard();
        this.player = new Player(gameBoard, menuPanel, this);
        this.enemy = new Enemy(gameBoard, menuPanel, this);
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
                enemy.update();
                repaint();
                delta--;
            }
        }
    }

    private void checkCollisionWithEnemy(int playerX, int playerY, int enemyX, int enemyY){
        int playerCoordinateXindex = playerX/this.blockSize;
        int playerCoordinateYindex = playerY/this.blockSize;

        int enemyCoordinateXindex = enemyX/this.blockSize;
        int enemyCoordinateYindex = enemyY/this.blockSize;

        if(playerCoordinateXindex == enemyCoordinateXindex && playerCoordinateYindex == enemyCoordinateYindex){
            player.decreaseScore();
            player.setCoordinateX(20);
            player.setCoordinateY(20);
        }
    }

    public void update() {
        if (keyHandler.isUpPressed()) {
            player.moveUp();
            checkCollisionWithEnemy(player.getCoordinateX(), player.getCoordinateY(), enemy.getCoordinateX(),
                    enemy.getCoordinateY());
        }
        else if (keyHandler.isDownPressed()) {
            player.moveDown();
            checkCollisionWithEnemy(player.getCoordinateX(), player.getCoordinateY(), enemy.getCoordinateX(),
                    enemy.getCoordinateY());
        }
        else if (keyHandler.isLeftPressed()) {
            player.moveLeft();
            checkCollisionWithEnemy(player.getCoordinateX(), player.getCoordinateY(), enemy.getCoordinateX(),
                    enemy.getCoordinateY());
        }
        else if (keyHandler.isRightPressed()) {
            player.moveRight();
            checkCollisionWithEnemy(player.getCoordinateX(), player.getCoordinateY(), enemy.getCoordinateX(),
                    enemy.getCoordinateY());
        }

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
        g.drawImage(resourceManager.getPlayer(),  player.getCoordinateX(), player.getCoordinateY(), this);
        g.drawImage(resourceManager.getEnemy(),  enemy.getCoordinateX(), enemy.getCoordinateY(), this);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public int getBlocksNumberInDirection() {
        return blocksNumberInDirection;
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }
}

