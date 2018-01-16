package fr.mg.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Observable;

public class Game extends Observable {

    private int oxygen;
    private ArrayList<Player> players;
    private ArrayList<Cave> caves;
    private int stage;
    private Thread t;
    private int currentInput = 0;
    private int currentFocus;

    public Game() {
        oxygen = 0;
        players = null;
        caves = new ArrayList<>();
        stage = 0;
        currentFocus = 0;
    }

    public void init(int playerCount) {
        // Création des caves
        for (int i = 0; i < 3; i++) {
            caves.add(new Cave(i + 1));
        }

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
        oxygen = 2 * getCavesSizes();

        // Lancement du jeu
        t = new Thread(new LaunchGame());
        t.start();

        this.updateObservers();
        System.out.println("Init sucessful");
    }

    class LaunchGame implements Runnable {
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            launchGame();
        }
    }

    public void launchGame() {
        stage = 1;
        while (stage < 4) {
            this.updateObservers();
            while (oxygen > 0) {
                playTurn();
            }

            // On replace tous les joueurs en haut / Ceux qui ne sont pas en haut perdent leurs coffres
            for (Player player : players) {
                if (player.getPosition() != 0) {
                    for (Chest chest : player.loseChests()) {
                        if (caves.get(2).getSize() != 0) {
                            caves.get(2).getLevel(caves.get(2).getSize() - 1).addChest(chest);
                        }
                    }
                    player.setPosition(0);
                }
            }

            // On met à jour les niveaux
            for (Cave cave : caves) {
                cave.removeEmpty();
            }

            // On recalcule l'oxygen entre chaque stage
            oxygen = 2 * getCavesSizes();

            // On passe au stage suivant
            stage++;
        }
        System.out.println("Partie terminée !");
    }

    public void playTurn() {
        // Le joueur le plus bas joue en premier
        ArrayList<Player> playerOrder = (ArrayList<Player>) players.clone();
        playerOrder.sort(Comparator.comparingInt(Player::getPosition).reversed());
        if (players.get(0).getPosition() == players.get(1).getPosition())
            Collections.shuffle(playerOrder);

        for (Player player : playerOrder) {
            // Le joueur a le focus
            currentFocus = player == players.get(0) ? 1 : 2;
            this.updateObservers();
            // On attend une action valide
            boolean validMove = false;
            while (!validMove) {
                switch (player.getNextMove(currentInput)) {
                    case UP:
                        if (player.getPosition() > 0) {
                            player.setPosition(player.getPosition() - 1);
                            oxygen -= (1 + player.chestCount());
                            validMove = true;
                        }
                        break;
                    case DOWN:
                        if (player.getPosition() < (getCavesSizes() - 1)) {
                            player.setPosition(player.getPosition() + 1);
                            oxygen -= (1 + player.chestCount());
                            validMove = true;
                        }
                        break;
                    case PICKUP:
                        if (getPlayerLevel(player).getChestCount() > 0) {
                            player.pickupChest(getPlayerLevel(player));
                            oxygen--;
                            validMove = true;
                        }
                        break;
                    case NONE:
                        break;
                }
            }
            // Si le joueur est en haut, il ouvre ses coffres
            if (player.getPosition() == 0) {
                ArrayList<Chest> chests = player.loseChests();
                for (Chest chest : chests) {
                    player.setScore(player.getScore() + chest.getTreasureCount());
                }
            }
            this.updateObservers();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Level getPlayerLevel(Player player) {
        int position = player.getPosition();
        if (position < 0 || position > (getCavesSizes() - 1)) {
            throw new IndexOutOfBoundsException();
        } else {
            if (position < caves.get(0).getSize()) {
                return caves.get(0).getLevel(position);
            } else if (position < caves.get(0).getSize() + caves.get(1).getSize() - 1) {
                return caves.get(1).getLevel(position - caves.get(0).getSize());
            } else {
                return caves.get(2).getLevel(position - caves.get(0).getSize() - caves.get(1).getSize());
            }
        }
    }

    public int getCavesSizes() {
        int size = 0;
        for (Cave cave : caves) {
            size += cave.getSize();
        }
        return size;
    }

    public void calculateScore() {
    }

    public void updateObservers() {
        ArrayList state = new ArrayList();
        // 0 : oxygen
        state.add(oxygen);
        // 1 : nom du joueur 1
        state.add(players.get(0).getName());
        // 2 : nom du joueur 2
        state.add(players.get(1).getName());
        // 3 / 4 / 5 : taille des caves
        for (Cave cave : caves) {
            state.add(cave.getSize());
        }
        // 6 : stage
        state.add(stage);
        // 7 : position du joueur 1
        state.add(players.get(0).getPosition());
        // 8 : position du joueur 2
        state.add(players.get(1).getPosition());
        // 9 : score du joueur 1
        state.add(players.get(0).getScore());
        // 10 : score du joueur 2
        state.add(players.get(1).getScore());
        // 11 : joueur ayant le focus
        state.add(currentFocus);
        // 12 : position des coffres
        ArrayList<Integer> posCoffres = new ArrayList<>();


        this.setChanged();

        this.notifyObservers(state);
    }

    public void setCurrentInput(int currentInput) {
        this.currentInput = currentInput;
    }

}