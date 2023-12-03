package AB.Mechanics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Checks which key is pressed
     * @param e input from keyboard
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W:
                this.upPressed = true;
                break;
            case KeyEvent.VK_S:
                this.downPressed = true;
                break;
            case KeyEvent.VK_A:
                this.leftPressed = true;
                break;
            case KeyEvent.VK_D:
                this.rightPressed = true;
                break;
        }
    }

    /**
     * Checks which key is released
     * @param e input from keyboard
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W:
                this.upPressed = false;
                break;
            case KeyEvent.VK_S:
                this.downPressed = false;
                break;
            case KeyEvent.VK_A:
                this.leftPressed = false;
                break;
            case KeyEvent.VK_D:
                this.rightPressed = false;
                break;
        }
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }
}
