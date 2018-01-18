package fr.mg.model;

public class AIPlayer extends Player {
    private boolean toggle;

    AIPlayer(String vname) {
        super(vname);
        toggle = true;
    }

    public Move getNextMove(int i) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (this.chestCount() > 0) {
            return Move.UP;
        } else {
            toggle = !toggle;
            return toggle ? Move.DOWN : Move.PICKUP;
        }
    }
}