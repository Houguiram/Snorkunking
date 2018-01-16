package fr.mg.vue;

import javax.swing.*;
import java.awt.*;

public class TopBar extends JPanel {
    String player1Name;
    String player2Name;
    int oxygen;
    int stage;
    int score1;
    int score2;
    int playerTurn;

    public TopBar(String player1Name, String player2Name, int oxygen, int stage, int score1, int score2, int playerTurn) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.oxygen = oxygen;
        this.stage = stage;
        this.score1 = score1;
        this.score2 = score2;
        this.playerTurn = playerTurn;
    }

    public void paintComponent(Graphics g) {
        // Background
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), 50);

        // Text
        int y = 15;
        g.setColor(Color.BLACK);
        g.drawString("Scores", 30, y);
        g.drawString("Stage " + stage + "/3", 30, y + 20);

        if (playerTurn == 1)
            g.setFont(g.getFont().deriveFont(Font.BOLD));
        g.drawString(player1Name + " :", 150, y);
        g.setFont(g.getFont().deriveFont(Font.PLAIN));


        g.drawString(String.valueOf(score1), 180, y);


        if (playerTurn == 2)
            g.setFont(g.getFont().deriveFont(Font.BOLD));
        g.drawString(player2Name + " :", 300, y);

        g.setFont(g.getFont().deriveFont(Font.PLAIN));

        g.drawString(String.valueOf(score2), 330, y);

        // Oxygen container
        g.drawRect(140, y + 5, 210, 20);

        //Oxygen bar
        g.setColor(Color.cyan);
        g.fillRoundRect(143, y + 8, oxygen * 4, 15, 5, 5);
    }

    public Dimension getPreferredSize() {
        return new Dimension(50, 50);
    }
}
