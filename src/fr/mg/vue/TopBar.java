package fr.mg.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TopBar extends JPanel {
    private String player1Name;
    private String player2Name;
    private int oxygen;
    private int stage;
    private int score1;
    private int score2;
    private int playerTurn;
    private int player1Stored;
    private int player2Stored;

    TopBar(String player1Name, String player2Name, int oxygen, int stage, int score1, int score2, int playerTurn, int player1Stored, int player2Stored) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.oxygen = oxygen;
        this.stage = stage;
        this.score1 = score1;
        this.score2 = score2;
        this.playerTurn = playerTurn;
        this.player1Stored = player1Stored;
        this.player2Stored = player2Stored;
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


        g.drawString(String.valueOf(score1) + " + " + player1Stored + " x ", 180, y);


        if (playerTurn == 2)
            g.setFont(g.getFont().deriveFont(Font.BOLD));
        g.drawString(player2Name + " :", 300, y);

        g.setFont(g.getFont().deriveFont(Font.PLAIN));

        g.drawString(String.valueOf(score2) + " + " + player2Stored + " x ", 330, y);

        // Chest stored
        try {
            Image img = ImageIO.read(new File("chest.png"));
            g.drawImage(img, 230, y - 20, 30, 30, this);
            g.drawImage(img, 380, y - 20, 30, 30, this);

        } catch (IOException e) {
            e.printStackTrace();
        }

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
