package fr.mg.vue;

import javax.swing.*;
import java.awt.*;

public class TopBar extends JPanel {
    public void paintComponent(Graphics g) {
        // Background
        g.setColor(Color.white);
        g.fillRect(0,0, this.getWidth(),50);

        // Text
        int y = 15;
        g.setColor(Color.BLACK);
        g.drawString("Scores",30,y);
        g.drawString("P1 :", 150,y);
        g.drawString("XX", 180, y);
        g.drawString("P2 :", 300,y);
        g.drawString("XX",330,y);

        // Oxygen container
        g.drawRect(140,y+5,210,20);

        //Oxygen bar
        g.setColor(Color.cyan);
        g.fillRoundRect(143,y+8,205,15,5,5);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50,50);
    }
}
