package fr.mg.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class EndMenu extends JPanel {
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    EndMenu(int p1s, int p2s, String p1n, String p2n) {
        this.player1Score = p1s;
        this.player2Score = p2s;
        this.player1Name = p1n;
        this.player2Name = p2n;
    }

    public void paintComponent(Graphics g) {
        String winner = "";
        boolean tie = false;

        if (player1Score > player2Score) {
            winner = player1Name;
        } else if (player2Score > player1Score) {
            winner = player2Name;
        } else {
            tie = true;
        }


        try {
            Image img = ImageIO.read(new File("endMenuBackground.jpg"));
            g.drawImage(img, 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.setColor(Color.white);
        g.setFont(g.getFont().deriveFont(43f));
        if (tie) {
            g.drawString("Égalité !", 170, 150);
        } else {
            g.drawString("Le gagnant est " + winner + " !", 50, 150);
        }

        g.setFont(g.getFont().deriveFont(35f));
        g.drawString(player1Name + " : " + player1Score, 80, 230);
        g.drawString(player2Name + " : " + player2Score, 300, 230);

    }
}
