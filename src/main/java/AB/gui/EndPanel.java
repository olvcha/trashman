package AB.gui;

import javax.swing.*;
import java.awt.*;


public class EndPanel extends JPanel{
    public EndPanel(long time, int points){
        this.setLayout(new FlowLayout());
        Font centuryGothicFont = new Font("Century Gothic", Font.BOLD, 24);

        JPanel marginPanel = new JPanel();
        marginPanel.setPreferredSize(new Dimension(500,180));
        this.add(marginPanel);

        JPanel messagePanel = new JPanel();
        messagePanel.setPreferredSize(new Dimension(500,50));
        JLabel messageLabel = new JLabel("You saved Korok Forest!");
        messageLabel.setFont(centuryGothicFont);
        messagePanel.add(messageLabel);
        this.add(messagePanel);


        JPanel timePanel = new JPanel();
        timePanel.setPreferredSize(new Dimension(500,50));
        JLabel timeLabel = new JLabel("");
        timeLabel.setFont(centuryGothicFont);
        long elapsedSeconds = time / 1000;
        long secondsDisplay = elapsedSeconds % 60;
        long elapsedMinutes = elapsedSeconds / 60;
        long minutesDisplay = elapsedMinutes % 60;
        if(secondsDisplay < 10){
            timeLabel.setText("Time: " + minutesDisplay + ":0" + secondsDisplay);
        }
        else{
            timeLabel.setText("Time: " + minutesDisplay + ":" + secondsDisplay);
        }
        timePanel.add(timeLabel);
        this.add(timePanel);


        JPanel pointsPanel = new JPanel();
        pointsPanel.setPreferredSize(new Dimension(500,50));
        JLabel pointsLabel = new JLabel("Points: " + points);
        pointsLabel.setFont(centuryGothicFont);
        pointsPanel.add(pointsLabel);
        this.add(pointsPanel);
    }
}

