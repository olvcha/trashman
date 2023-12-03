package AB.gui;

import AB.reading.ResourceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GamePanel extends JPanel {
    private GameBoard gameBoard;
    private ResourceManager resourceManager;
    private int blockSize;
    private int width;
    private int height;
    private int blocksNumberInDirection;

    public GamePanel(int width, int height){
        this.width = width;
        this.height = height;
        this.blocksNumberInDirection = 25;
        setPreferredSize(new Dimension(width, height));
        this.gameBoard = new GameBoard();
        this.resourceManager = new ResourceManager();
        this.blockSize = width/this.blocksNumberInDirection; // width/25=20
    }

    private void generateMap(){

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D rectangle = new Rectangle2D.Double(0, 0, 500, 500);
        g2d.setColor(Color.black);
        g2d.fill(rectangle);

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
                }
            }
        }

    }
    //public void draw(Graphics2D g, int width, int height){
    //    g.drawImage(resourceManager.getWall(), width, height);
    //}

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
}

