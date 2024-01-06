package AB.reading;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceManager {
    ClassLoader classLoader;
    BufferedImage wall;
    BufferedImage nothing;
    BufferedImage player;
    BufferedImage enemy;
    BufferedImage glass;
    BufferedImage plastic;
    BufferedImage paper;
    BufferedImage heart;
    BufferedImage background;

    public ResourceManager(){
        this.classLoader = ResourceManager.class.getClassLoader();
        loadResources();
    }

    /**
     * Loading images of a wall, nothing(background), player, trash, enemy
     */
    private void loadResources(){
        try {
            wall = ImageIO.read(new File(classLoader.getResource("textures/Tree.png").getPath()));
            nothing = ImageIO.read(new File(classLoader.getResource("textures/Grass.png").getPath()));
            player = ImageIO.read(new File(classLoader.getResource("textures/Korok.png").getPath()));
            enemy = ImageIO.read(new File(classLoader.getResource("textures/enemy.png").getPath()));
            glass = ImageIO.read(new File(classLoader.getResource("textures/glass.png").getPath()));
            plastic = ImageIO.read(new File(classLoader.getResource("textures/plastic.png").getPath()));
            paper = ImageIO.read(new File(classLoader.getResource("textures/paper.png").getPath()));
            heart = ImageIO.read(new File(classLoader.getResource("textures/heart.png").getPath()));
            background = ImageIO.read(new File(classLoader.getResource("textures/background.jpg").getPath()));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getWall() {
        return wall;
    }
    public BufferedImage getNothing() {
        return nothing;
    }
    public BufferedImage getPlayer() { return player; }
    public BufferedImage getGlass() { return glass; }
    public BufferedImage getPlastic() { return plastic; }
    public BufferedImage getPaper() { return paper; }
    public BufferedImage getEnemy() { return enemy; }
    public BufferedImage getHeart() { return heart; }
    public BufferedImage getBackground() { return background; }



}
