package fr.mg.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import fr.mg.model.Game;
import fr.mg.model.GameStatus;

public class IHM extends JFrame {
    private Game game;
    private ArrayList gameState;

    public IHM() {
        boolean restart = true;
        boolean running;
        while (restart) {
            // Setup de la fenêtre
            this.setSize(500, 500);
            this.setTitle("Snorkunking");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setFocusable(true);
            this.addKeyListener(new ClavierListener());
            boolean needRefresh;

            // Menu principal
            JPanel container = new JPanel();
            container.setLayout(new GridLayout(0, 1));
            container.add(new MainMenu());
            this.setContentPane(container);
            this.validate();
            this.setVisible(true);

            // Lancement du jeu

            this.game = new Game();
            this.game.addObserver((o, state) -> gameState = (ArrayList) state);

            // Sélection du mode de jeu
            while (game.getCurrentInput() != 65 && game.getCurrentInput() != 66) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (game.getCurrentInput() == 65) {
                game.init(1);
            } else {
                game.init(2);
            }

            while (gameState.get(13) == GameStatus.STOPPED) { // On attend la fin du Init
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            do { // Tant que la partie n'est pas terminée
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
                        (int) gameState.get(11),
                        (int) gameState.get(14),
                        (int) gameState.get(15)), BorderLayout.NORTH);

                // On crée une vue du jeu avec les caves, les joueurs et les coffres
                container.add(new GameView((int) gameState.get(3),
                        (int) gameState.get(4),
                        (int) gameState.get(5),
                        (int) gameState.get(7),
                        (int) gameState.get(8),
                        (ArrayList<Integer>) gameState.get(12)), BorderLayout.CENTER);

                this.setContentPane(container);
                this.validate();
                this.repaint();

                needRefresh = false;
                ArrayList oldState = (ArrayList) gameState.clone();
                do {
                    if (!oldState.equals(gameState))
                        needRefresh = true;
                } while (!needRefresh);

                running = gameState.get(13) == GameStatus.RUNNING;

                switch ((GameStatus) gameState.get(13)) { // Quel est l'état du jeu
                    case RUNNING: // Le jeu continue
                        running = true;
                        break;
                    case STOPPED: // Le jeu est terminé
                        running = false;
                        break;
                    case ENDOFSTAGE: // Le jeu est entre deux stages
                        container = new JPanel();
                        container.setLayout(new GridLayout(0, 1));
                        container.add(new StageMenu((int) gameState.get(9),
                                (int) gameState.get(10),
                                (String) gameState.get(1),
                                (String) gameState.get(2)));
                        this.setContentPane(container);
                        this.validate();
                        this.repaint();
                        do {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } while (gameState.get(13) == GameStatus.ENDOFSTAGE);

                        running = gameState.get(13) == GameStatus.RUNNING;

                        break;
                }
            } while (running);
            // Menu End
            container = new JPanel();
            container.setLayout(new GridLayout(0, 1));
            container.add(new EndMenu((int) gameState.get(9),
                    (int) gameState.get(10),
                    (String) gameState.get(1),
                    (String) gameState.get(2)));
            this.setContentPane(container);
            this.validate();
            this.repaint();

            // On demande au joueur s'il veut rejouer
            while (game.getCurrentInput() != 65 && game.getCurrentInput() != 66) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            restart = game.getCurrentInput() == 65;
        }
        System.exit(0);
    }

    private class ClavierListener implements KeyListener {
        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
            game.setCurrentInput(e.getKeyCode());
            try {
                Thread.sleep(3);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            game.setCurrentInput(0);
        }
    }
}
