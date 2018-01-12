package fr.mg.vue;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    int cave1;
    int cave2;
    int cave3;
    int player1Pos;
    int player2Pos;

    public GameView(int cave1, int cave2, int cave3) {
        this.cave1 = cave1;
        this.cave2 = cave2;
        this.cave3 = cave3;
        this.player1Pos = 0;
        this.player2Pos = 0;
    }


    public void paintComponent(Graphics g) {
        // Setup caves sizes
        System.out.println("Taille cave 1 : "+cave1);
        System.out.println("Taille cave 2 : "+cave2);
        System.out.println("Taille cave 3 : "+cave3);

        int x = 100, w = 300;
        int textX = x + (w / 2) - 15;
        int c1Y = 10, c1H = cave1 * 14;
        int c2Y = c1H + c1Y + 5, c2H = cave2 * 14;
        int c3Y = c2Y + c2H + 5, c3H = cave3 * 14;
/*
        int c1Y = 10, c1H = 250;
        int c2Y = c1H + c1Y + 5, c2H = 100;
        int c3Y = c2Y + c2H + 5, c3H = 30;
*/
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
