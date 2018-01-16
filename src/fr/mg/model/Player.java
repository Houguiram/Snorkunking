package fr.mg.model;

import java.util.ArrayList;

public abstract class Player {

    private int position;
    private String name;
    private ArrayList<Chest> chests;
    private int treasureCount;

    public Player(String vname) {
        name = vname;
        position = 0;
        treasureCount = 0;
        chests = new ArrayList<>();
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
        ArrayList<Chest> lost = chests;
        chests.removeAll(lost);
        return lost;
    }

    public int chestCount() {
        return chests.size();
    }

    public abstract Move getNextMove(int input);

}