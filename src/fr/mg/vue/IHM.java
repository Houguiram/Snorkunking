package fr.mg.vue;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import fr.mg.model.Game;

public class IHM extends JFrame {
    private JPanel container = new JPanel();
    private Game game;
    private ArrayList gameState;

    public IHM(Game game) {
        // Setup de la fenêtre
        this.setSize(500, 500);
        this.setTitle("Snorkunking");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setFocusable(true);
        this.addKeyListener(new ClavierListener());

        // Lancement du jeu
        this.game = game;
        this.game.addObserver((o, state) -> gameState = (ArrayList) state);
        game.init(2);
        while (true) {
            this.invalidate();
            container = new JPanel();
            // Setup du layout de la fenêtre de jeu
            container.setBackground(Color.blue);
            container.setLayout(new BorderLayout());

            // On crée une barre d'information avec les infos des joueurs et l'oxygène
            container.add(new TopBar((String) gameState.get(1),
                    (String) gameState.get(2),
                    (int) gameState.get(0),
                    (int) gameState.get(6),
                    (int) gameState.get(9),
                    (int) gameState.get(10),
                    (int) gameState.get(11)), BorderLayout.NORTH);

            // On crée une vue du jeu avec les caves et les joueurs
            container.add(new GameView((int) gameState.get(3),
                    (int) gameState.get(4),
                    (int) gameState.get(5),
                    (int) gameState.get(7),
                    (int) gameState.get(8)), BorderLayout.CENTER);

            this.setContentPane(container);
            this.validate();
            this.repaint();

            this.setVisible(true);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClavierListener implements KeyListener {
        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
            game.setCurrentInput(e.getKeyCode());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            game.setCurrentInput(0);
            System.out.println("Touche pressée : " + e.getKeyCode());
        }
    }
}
