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

    public Game(){
        oxygen = 0;
        players = null;
        cave1 = null;
        cave2 = null;
        cave3 = null;
        stage = 0;
    }



    public void playTurn() {
    }

    public void init(int playerCount) {
        cave1 = new Cave(1);
        cave2 = new Cave(2);
        cave3 = new Cave(3);
        stage = 1;
        players = new ArrayList<Player>();
        if (playerCount == 1){
            players.add(new AIPlayer("Bot"));
            players.add(new HumanPlayer("Player"));
        } else if (playerCount == 2){
            players.add(new HumanPlayer("Player 1"));
            players.add(new HumanPlayer("Player 2"));
        }
        IHM vue = new IHM();
        System.out.println("Init sucessful");
    }

    public void calculateScore() {
    }

    public void launchGame() {
    }

}