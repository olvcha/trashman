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
import java.io.IOException;
import java.util.Random;
import java.util.List;

public class GamePanel extends JPanel implements Runnable{
    private GameFrame frame;
    private MenuPanel menuPanel;
    private Player player;
    private Enemy enemy;

    private ResourceManager resourceManager;
    private int blockSize;
    private int width;
    private int height;
    private int blocksNumberInDirection;
    private int trashAmount;
    private JLabel gameOver;
    final int FPS = 60;
    private KeyHandler keyHandler = new KeyHandler();
    private Thread gameThread;
    private Music music;
    private char mapType = 'X';
    private long startTime;
    private long elapsedTime = 0;

    /**
     * GamePanel class constructor
     * @param width width of the game panel
     * @param height height of the game panel
     * @param menuPanel menu panel
     */
    public GamePanel(int width, int height, MenuPanel menuPanel, GameFrame frame, Player player, long startTime){
        this.frame = frame;
        this.width = width;
        this.height = height;
        this.blocksNumberInDirection = 25;
        this.setPreferredSize(new Dimension(width, height));
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.menuPanel = menuPanel;

        this.startTime = startTime;
        this.player = player;
        player.setCurrentGame(menuPanel, this);

        //this.player = new Player(menuPanel, this);
        this.enemy = new Enemy(player.getGameBoard(), menuPanel, this);
        this.resourceManager = new ResourceManager();
        this.gameOver = new JLabel("");

        this.blockSize = width/this.blocksNumberInDirection; // width/25=20
        try {
            this.music = new Music();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        Font centuryGothicFont = new Font("Century Gothic", Font.PLAIN, 40);
        gameOver.setFont(centuryGothicFont);
        this.add(gameOver);
        chooseLevel();
    }

    /**
     * Starting game thread
     */
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
        music.play();
    }

    /**
     * Ending game thread
     */
    public void endGameThread(){
        music.stop();
        gameThread.stop();
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

                elapsedTime = System.currentTimeMillis() - startTime;
                menuPanel.setTime(elapsedTime);
            }

            if(player.getTrashCollected() == trashAmount){
                if(player.getLevelsDone().size() == 5){
                    System.out.println("You saved Korok Forest Yahahaha!");
                    new EndFrame(elapsedTime, player.getScore());
                    endGameThread();
                }
                System.out.println(this.mapType + " level done");
                trashAmount = 0;
                this.frame.dispose();
                keyHandler = null;
                new GameFrame(player, startTime);
                endGameThread();
            }
        }
    }

    /**
     * Checking collision between two objects - a player and an enemy
     * @param playerX player's x coordinate
     * @param playerY player's y coordinate
     * @param enemyX enemy's x coordinate
     * @param enemyY enemy's y coordinate
     */
    private void checkCollisionWithEnemy(int playerX, int playerY, int enemyX, int enemyY){
        int playerCoordinateXindex = playerX/this.blockSize;
        int playerCoordinateYindex = playerY/this.blockSize;

        int enemyCoordinateXindex = enemyX/this.blockSize;
        int enemyCoordinateYindex = enemyY/this.blockSize;

        if(playerCoordinateXindex == enemyCoordinateXindex && playerCoordinateYindex == enemyCoordinateYindex){
            player.decreaseHearts();
            player.setCoordinateX(20);
            player.setCoordinateY(20);
        }
    }

    /**
     * Updating the map after player's move, checking collision with an enemy
     */
    public void update() {
        if(keyHandler != null) {
            if (keyHandler.isUpPressed()) {
                player.moveUp();
                checkCollisionWithEnemy(player.getCoordinateX(), player.getCoordinateY(), enemy.getCoordinateX(),
                        enemy.getCoordinateY());
            } else if (keyHandler.isDownPressed()) {
                player.moveDown();
                checkCollisionWithEnemy(player.getCoordinateX(), player.getCoordinateY(), enemy.getCoordinateX(),
                        enemy.getCoordinateY());
            } else if (keyHandler.isLeftPressed()) {
                player.moveLeft();
                checkCollisionWithEnemy(player.getCoordinateX(), player.getCoordinateY(), enemy.getCoordinateX(),
                        enemy.getCoordinateY());
            } else if (keyHandler.isRightPressed()) {
                player.moveRight();
                checkCollisionWithEnemy(player.getCoordinateX(), player.getCoordinateY(), enemy.getCoordinateX(),
                        enemy.getCoordinateY());
            }
        }
    }

    private void chooseLevel(){
        Random random = new Random();

        int level = 9999;
        List<Character> map = null;
        while(player.getLevelsDone().contains(mapType)) {
            level = random.nextInt(4);
            switch (level) {
                case 0: {
                    mapType = 'A';
                    map = player.getBoards().get(level);
                    gameOver.setText("Collect all");
                    break;
                }
                case 1: {
                    mapType = 'P';
                    map = player.getBoards().get(level);
                    gameOver.setText("Collect plastic");
                    break;
                }
                case 2: {
                    mapType = 'G';
                    map = player.getBoards().get(level);
                    gameOver.setText("Collect glass");
                    break;
                }
                case 3: {
                    mapType = 'B';
                    map = player.getBoards().get(level);
                    gameOver.setText("Collect paper");
                    break;
                }
            }
        }
        player.getGameBoard().setCurrentMap(mapType);
        trashAmount = player.getGameBoard().getTrashAmount(mapType, map);

        player.updateLevelsDone(mapType, level);
    }

    /**
     * Painting the game board, including things such as walls, grass, characters etc.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //Painting board
        for (int h = 0; h < this.blocksNumberInDirection; h++){
            for (int w = 0; w < this.blocksNumberInDirection; w++){
                char block = player.getGameBoard().getBoard().get(h * this.blocksNumberInDirection + w);
                switch(block){
                    case 'W':
                        g.drawImage(resourceManager.getWall(), w * this.blockSize, h * this.blockSize,
                                this);
                        break;
                    case 'N':
                        g.drawImage(resourceManager.getNothing(), w * this.blockSize, h * this.blockSize,
                                this);
                        break;
                    case 'G':
                        g.drawImage(resourceManager.getGlass(), w * this.blockSize, h * this.blockSize,
                                this);
                        break;
                    case 'P':
                        g.drawImage(resourceManager.getPlastic(), w * this.blockSize, h * this.blockSize,
                                this);
                        break;
                    case 'B':
                        g.drawImage(resourceManager.getPaper(), w * this.blockSize, h * this.blockSize,
                                this);
                        break;
                }
            }
        }

        //Painting character
        g.drawImage(resourceManager.getPlayer(),  player.getCoordinateX(), player.getCoordinateY(), this);
        g.drawImage(resourceManager.getEnemy(),  enemy.getCoordinateX(), enemy.getCoordinateY(), this);

        //Painting hearts
        switch(player.getHearts()){
            case 0: {
                gameOver.setText("Game over!");
                endGameThread();

            }
            case 1:{
                g.drawImage(resourceManager.getHeart(),  0, 0, this);
                break;
            }
            case 2:{
                g.drawImage(resourceManager.getHeart(),  0, 0, this);
                g.drawImage(resourceManager.getHeart(),  20, 0, this);
                break;
            }
            case 3:{
                g.drawImage(resourceManager.getHeart(),  0, 0, this);
                g.drawImage(resourceManager.getHeart(),  20, 0, this);
                g.drawImage(resourceManager.getHeart(),  40, 0, this);
                break;
            }
        }

    }

    /**
     * Getting preferred size of a panel
     * @return dimension
     */
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

