package fr.mg.model;

import java.util.ArrayList;
import java.util.Random;

// Each cave contains levels
public class Cave {
    // Each cave contains levels
    private ArrayList<Level> levels;

    public Cave(int caveType) {
        Random rand = new Random();
        int levelNbrs;
        switch (caveType) { // 3 types of caves
            case 1: // between 9 and 12 levels
                levelNbrs = rand.nextInt(12 - 9 + 1) + 9;
                break;
            case 2: //between 6 and 9 levels
                levelNbrs = rand.nextInt(9 - 6 + 1) + 6;
                break;
            case 3: //between 3 and 6 levels
                levelNbrs = rand.nextInt(6 - 3 + 1) + 3;
                break;
            default:
                throw new IllegalArgumentException(Integer.toString(caveType));
        }
        levels = new ArrayList<>();
        for (int i = 0; i < levelNbrs; i++){
            levels.add(new Level(caveType));
        }
    }

    public Level getLevel(int index) {
        return levels.get(index);
    }

    public int getSize(){
        return levels.size();
    }

    public void removeEmpty(){
        for (Level level : levels){
            if (level.getChestCount() == 0){
                levels.remove(level);
            }
        }
    }
}