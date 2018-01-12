package fr.mg.vue;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import fr.mg.model.Game;

public class IHM extends JFrame {
    private JPanel container = new JPanel();
    private Game game;
    private ArrayList gameState;

    public IHM() {
        // Setup the window
        this.setSize(500, 500);
        this.setTitle("Snorkunking");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Lancement du jeu

        this.game = new Game();
        this.game.addObserver(new Observer() {
            public void update(Observable o, Object state) {
                gameState = (ArrayList) state;
            }
        });
        game.init(2);
        System.out.println("after: " + gameState);

        // Setup window's content
        container.setBackground(Color.blue);
        container.setLayout(new BorderLayout());
        container.add(new TopBar((String) gameState.get(1), (String) gameState.get(2), (int) gameState.get(0)), BorderLayout.NORTH);
        // On crée une vue avec la taille des caves

        container.add(new GameView((int) gameState.get(3), (int) gameState.get(4), (int) gameState.get(5)), BorderLayout.CENTER);

        this.setContentPane(container);

        this.setVisible(true);
    }
}
