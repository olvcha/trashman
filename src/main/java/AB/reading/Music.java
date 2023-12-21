package AB.reading;

import AB.gui.GameBoard;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    private Clip clip;

    public String filePath(String resource){
        ClassLoader classLoader = GameBoard.class.getClassLoader();
        return classLoader.getResource(resource).getPath();
    }

    public Music() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        ClassLoader classLoader = GameBoard.class.getClassLoader();
        File audioFile = new File(classLoader.getResource("music/KorokForest.wav").getPath());
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
        clip.setFramePosition(0); // Reset to the beginning
    }
}
