package fr.mg.vue;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    public void paintComponent(Graphics g) {
        // Setup caves sizes
        int x = 100, w = 300;
        int textX = x + (w / 2) - 15;
        int c1Y = 10, c1H = 250;
        int c2Y = 265, c2H = 100;
        int c3Y = 370, c3H = 30;

        g.setColor(Color.yellow);

        // Cave 1
        g.fillRect(x, c1Y, w, c1H);

        // Cave 2
        g.fillRect(x, c2Y, w, c2H);

        // Cave 3
        g.fillRect(x, c3Y, w, c3H);

        // Cave texts
        g.setColor(Color.BLACK);
        g.drawString("Cave 1", textX, c1Y + (c1H / 2));
        g.drawString("Cave 2", textX, c2Y + (c2H / 2));
        g.drawString("Cave 3", textX, c3Y + (c3H / 2));

        // Players

        g.setColor(Color.red);
        g.fillOval(x+50,c1Y,30,30);
        g.setColor(Color.magenta);
        g.fillOval(x+220,c1Y,30,30);


    }
}
