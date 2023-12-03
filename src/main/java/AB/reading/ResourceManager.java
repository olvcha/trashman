package AB.reading;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceManager {
    ClassLoader classLoader;
    BufferedImage wall;
    BufferedImage nothing;

    public ResourceManager(){
        this.classLoader = ResourceManager.class.getClassLoader();
        loadResources();
    }

    private void loadResources(){
        try {
            wall = ImageIO.read(new File(classLoader.getResource("Wall.png").getPath()));
            nothing = ImageIO.read(new File(classLoader.getResource("Nothing.png").getPath()));
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


}
