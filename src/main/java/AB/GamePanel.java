package AB;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GamePanel extends JPanel {

    public GamePanel(){
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D rectangle = new Rectangle2D.Double(0, 0, 500, 500);
        g2d.setColor(Color.black);
        g2d.fill(rectangle);
       // g2d.draw(rectangle);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
}
