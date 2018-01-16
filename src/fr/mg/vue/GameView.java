package fr.mg.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameView extends JPanel {
    private int cave1;
    private int cave2;
    private int cave3;
    private int player1Pos;
    private int player2Pos;
    private ArrayList<Integer> chestsPos;

    GameView(int cave1, int cave2, int cave3, int player1Pos, int player2Pos, ArrayList<Integer> chestsPos) {
        this.cave1 = cave1;
        this.cave2 = cave2;
        this.cave3 = cave3;
        this.player1Pos = player1Pos;
        this.player2Pos = player2Pos;
        this.chestsPos = chestsPos;
    }

    public void paintComponent(Graphics g) {
        // Setup caves sizes
        int x = 100, w = 300;
        int textX = x + (w / 2) - 15;
        int c1Y = 10, c1H = cave1 * 14;
        int c2Y = c1H + c1Y + 1, c2H = cave2 * 14;
        int c3Y = c2Y + c2H + 1, c3H = cave3 * 14;

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

        // Chests
        try {
            Image img = ImageIO.read(new File("chest.png"));
            for (int i = 0; i < chestsPos.size(); i++){
                if (chestsPos.get(i).equals(1))
                    g.drawImage(img, x - 30, c1Y + (i * 14) - 8,30,30, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Players
        try {
            Image img = ImageIO.read(new File("diver.png"));
            g.drawImage(img,x + 50, c1Y + (player1Pos * 14) - 13,40,40, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Image img = ImageIO.read(new File("diver2.png"));
            g.drawImage(img,x + 220, c1Y + (player2Pos * 14) - 13,40,40, this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
