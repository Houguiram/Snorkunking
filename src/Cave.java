import java.util.ArrayList;
import java.util.Random;

// Each cave contains levels
public class Cave {
    private ArrayList<Level> levels;

    public Cave(int caveType) {
        Random rand = new Random();
        int levelNbrs;
        switch (caveType) { // 3 types of caves
            case 1:
                levelNbrs = rand.nextInt(12 - 9 + 1) + 9;
                break;
            case 2:
                levelNbrs = rand.nextInt(9 - 6 + 1) + 6;
                break;
            case 3:
                levelNbrs = rand.nextInt(6 - 3 + 1) + 3;
                break;
            default:
                throw new IllegalArgumentException(Integer.toString(caveType));
        }
        levels = new ArrayList<Level>();
        for (int i = 0; i < levelNbrs; i++){
            levels.add(new Level(caveType));
        }
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }
}