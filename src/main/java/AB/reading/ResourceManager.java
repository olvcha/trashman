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

    public ResourceManager(){
        this.classLoader = ResourceManager.class.getClassLoader();
        loadResources();
    }

    private void loadResources(){
        try {
            wall = ImageIO.read(new File(classLoader.getResource("Wall.png").getPath()));
            nothing = ImageIO.read(new File(classLoader.getResource("Nothing.png").getPath()));
            player = ImageIO.read(new File(classLoader.getResource("Korok.jpg").getPath()));
            //....
            //...
            //...
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
    public BufferedImage getPlayer() {
        return player;
    }



}
