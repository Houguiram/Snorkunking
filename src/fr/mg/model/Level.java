package fr.mg.model;

import java.util.ArrayList;
import java.util.Random;

public class Level {

    private ArrayList<Chest> chests;

    public Level(int caveType){
        Random rand = new Random();
        int treasureCount;
        switch (caveType) { // 3 types of caves
            case 1:
                treasureCount = rand.nextInt(3 - 1 + 1) + 1;
                break;
            case 2:
                treasureCount = rand.nextInt(8 - 5 + 1) + 5;
                break;
            case 3:
                treasureCount = rand.nextInt(12 - 10 + 1) + 10;
                break;
            default:
                throw new IllegalArgumentException(Integer.toString(caveType));
        }
        chests = new ArrayList<Chest>();
        chests.add(new Chest(treasureCount));
    }

    public ArrayList<Chest> getChests() {
        return chests;
    }

    public void setChests(ArrayList<Chest> chests) {
        this.chests = chests;
    }


}