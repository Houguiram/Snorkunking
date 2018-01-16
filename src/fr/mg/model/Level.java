package fr.mg.model;

import java.util.ArrayList;
import java.util.Random;

public class Level {

    private ArrayList<Chest> chests;

    public Level(int caveType) {
        Random rand = new Random();
        int treasureCount;
        switch (caveType) { // 3 types of caves
            case 1: //between 1 and 3 treasures
                treasureCount = rand.nextInt(3 - 1 + 1) + 1;
                break;
            case 2: //between 5 and 8 treasures
                treasureCount = rand.nextInt(8 - 5 + 1) + 5;
                break;
            case 3: //between 10 and 12 treasures
                treasureCount = rand.nextInt(12 - 10 + 1) + 10;
                break;
            default:
                throw new IllegalArgumentException(Integer.toString(caveType));
        }
        chests = new ArrayList<>();
        chests.add(new Chest(treasureCount));
    }

    public int getChestCount() {
        return chests.size();
    }

    public void addChest(Chest chest) {
        chests.add(chest);
    }

    public Chest dropChest() {
        Chest chest = chests.get(0);
        chests.remove(0);
        return chest;
    }


}