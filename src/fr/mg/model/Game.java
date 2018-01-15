package fr.mg.model;

import fr.mg.vue.IHM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Observable;

public class Game extends Observable {

    private int oxygen;
    private ArrayList<Player> players;
    private Cave cave1;
    private Cave cave2;
    private Cave cave3;
    private int stage;
    private Thread t;

    public Game() {
        oxygen = 0;
        players = null;
        cave1 = null;
        cave2 = null;
        cave3 = null;
        stage = 0;
    }


    public void playTurn() {
        // Le joueur le plus bas joue en premier
        ArrayList<Player> playerOrder = players;
        playerOrder.sort(Comparator.comparingInt(Player::getPosition).reversed());

        for (Player player : playerOrder) {

        }


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
            players.add(new HumanPlayer("P1"));
            players.add(new AIPlayer("AI"));
        } else if (playerCount == 2) {
            players.add(new HumanPlayer("P1"));
            players.add(new HumanPlayer("P2"));
        }

        // Oxygen = 2 * nbr de niveaux
        oxygen = 2 * (cave1.getSize() + cave2.getSize() + cave3.getSize());

        // Lancement du jeu
        t = new Thread(new LaunchGame());
        //launchGame();
        this.updateObservers();
        System.out.println("Init sucessful");
    }

    public void calculateScore() {
    }

    public void launchGame() {
        stage = 1;
        while (stage < 4) {
            while (oxygen > 0) {
                System.out.println("Début du tour");
                playTurn();
                System.out.println("Tour joué !");
                this.updateObservers();
            }
            // On met à jour les niveaux
            cave1.removeEmpty();
            cave2.removeEmpty();
            cave3.removeEmpty();

            // On recalcule l'oxygen entre chaque stage
            oxygen = 2 * (cave1.getSize() + cave2.getSize() + cave3.getSize());

            // On replace tous les joueurs en haut
            for (Player player : players) {
                player.setPosition(0);
            }

            // On passe au stage suivant
            stage++;
            this.updateObservers();
        }
        System.out.println("Partie terminée !");
    }

    public void updateObservers() {
        ArrayList state = new ArrayList();
        // 0 : oxygen
        state.add(oxygen);
        // 1 : nom du joueur 1
        state.add(players.get(0).getName());
        // 2 : nom du joueur 2
        state.add(players.get(1).getName());
        // 3 : taille de la cave 1
        state.add(cave1.getSize());
        // 4 : taille de la cave 2
        state.add(cave2.getSize());
        // 5 : taille de la cave 3
        state.add(cave3.getSize());
        // 6 : stage
        state.add(stage);
        // 7 : position du joueur 1
        state.add(players.get(0).getPosition());
        // 8 : position du joueur 2
        state.add(players.get(1).getPosition());

        this.setChanged();

        this.notifyObservers(state);
    }

    class LaunchGame implements Runnable {
        public void run() {
            launchGame();
        }
    }

}