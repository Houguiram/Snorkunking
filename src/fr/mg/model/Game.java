package fr.mg.model;

import fr.mg.vue.IHM;

import java.util.ArrayList;

public class Game {

    private int oxygen;
    private ArrayList<Player> players;
    private Cave cave1;
    private Cave cave2;
    private Cave cave3;
    private int stage;

    public Game() {
        oxygen = 0;
        players = null;
        cave1 = null;
        cave2 = null;
        cave3 = null;
        stage = 0;
    }


    public void playTurn() {

        Player currentPlayer = null;


    }

    public void init(int playerCount) {
        // Création des caves
        cave1 = new Cave(1);
        cave2 = new Cave(2);
        cave3 = new Cave(3);

        stage = 1;
        // Création des joueurs
        players = new ArrayList<Player>();

        if (playerCount == 1) {
            players.add(new HumanPlayer());
            players.add(new AIPlayer(cave1.getLevels().get(0)));
        } else if (playerCount == 2) {
            players.add(new HumanPlayer());
            players.add(new HumanPlayer());
        }

        // Oxygen = 2 * nbr de niveaux
        oxygen = 2 * (cave1.getSize() + cave2.getSize() + cave3.getSize());

        // Création de la vue
        IHM vue = new IHM(cave1.getSize(), cave2.getSize(), cave3.getSize());

        // Lancement du jeu
        launchGame();
        System.out.println("Init sucessful");
    }

    public void calculateScore() {
    }

    public void launchGame() {
        stage = 0;
        while (stage < 3) {
            while (oxygen > 0) {
                playTurn();
            }
            // On met à jour les niveaux
            cave1.removeEmpty();
            cave2.removeEmpty();
            cave3.removeEmpty();

            // On recalcule l'oxygen entre chaque stage
            oxygen = 2 * (cave1.getSize() + cave2.getSize() + cave3.getSize());

            // On passe au stage suivant
            stage++;
        }
        System.out.println("Partie terminée !");
    }

}