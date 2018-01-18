package fr.mg.model;

import java.util.ArrayList;

public abstract class Player {

    private int position;
    private String name;
    private ArrayList<Chest> chests;
    private ArrayList<Chest> stored;
    private int score;

    Player(String vname) {
        name = vname;
        position = 0;
        score = 0;
        chests = new ArrayList<>();
        stored = new ArrayList<>();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void pickupChest(Level level) {
        chests.add(level.dropChest());
    }

    public ArrayList<Chest> loseChests() {
        ArrayList<Chest> lost = (ArrayList<Chest>) chests.clone();
        chests.removeAll(lost);
        return lost;
    }

    public int chestCount() {
        return chests.size();
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public ArrayList<Chest> getStored() {
        return stored;
    }

    public void addStored(ArrayList<Chest> toStore) {
        this.stored.addAll(toStore);
    }

    public abstract Move getNextMove(int input);

}