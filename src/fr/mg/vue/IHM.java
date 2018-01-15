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

    public IHM(Game game) {
        // Setup de la fenêtre
        this.setSize(500, 500);
        this.setTitle("Snorkunking");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Lancement du jeu

        this.game = game;
        this.game.addObserver(new Observer() {
            public void update(Observable o, Object state) {
                gameState = (ArrayList) state;
            }
        });
        game.init(2);
        System.out.println("after: " + gameState);

        // Setup du layout de la fenêtre de jeu
        container.setBackground(Color.blue);
        container.setLayout(new BorderLayout());

        // On crée une barre d'information avec les infos des joueurs et l'oxygène
        container.add(new TopBar((String) gameState.get(1),
                (String) gameState.get(2),
                (int) gameState.get(0),
                (int) gameState.get(6)), BorderLayout.NORTH);

        // On crée une vue du jeu avec les caves et les joueurs
        container.add(new GameView((int) gameState.get(3),
                (int) gameState.get(4),
                (int) gameState.get(5),
                (int) gameState.get(7),
                (int) gameState.get(8)), BorderLayout.CENTER);

        this.setContentPane(container);

        this.setVisible(true);
    }
}
