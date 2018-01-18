package fr.mg.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StageMenu extends JPanel {
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    StageMenu(int p1s, int p2s, String p1n, String p2n) {
        this.player1Score = p1s;
        this.player2Score = p2s;
        this.player1Name = p1n;
        this.player2Name = p2n;
    }

    public void paintComponent(Graphics g) {
        try {
            Image img = ImageIO.read(new File("stageMenuBackground.jpg"));
            g.drawImage(img, 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.setFont(g.getFont().deriveFont(Font.BOLD, 60f));
        g.setColor(Color.white);
        g.drawString(player1Name + " : " + player1Score, 80, 230);
        g.drawString(player2Name + " : " + player2Score, 300, 230);

    }
}
