package fr.mg.vue;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private int cave1;
    private int cave2;
    private int cave3;
    private int player1Pos;
    private int player2Pos;

    public GameView(int cave1, int cave2, int cave3, int player1Pos,int player2Pos) {
        this.cave1 = cave1;
        this.cave2 = cave2;
        this.cave3 = cave3;
        this.player1Pos = player1Pos;
        this.player2Pos = player2Pos;
    }


    public void paintComponent(Graphics g) {
        // Setup caves sizes

        int x = 100, w = 300;
        int textX = x + (w / 2) - 15;
        int c1Y = 10, c1H = cave1 * 14;
        int c2Y = c1H + c1Y + 5, c2H = cave2 * 14;
        int c3Y = c2Y + c2H + 5, c3H = cave3 * 14;

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
        g.fillOval(x+50,c1Y+(player1Pos*14),14,14);
        g.setColor(Color.magenta);
        g.fillOval(x+220,c1Y+(player2Pos*14),14,14);


    }
}
