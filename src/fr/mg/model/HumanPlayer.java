package fr.mg.model;

import java.util.concurrent.TimeUnit;

public class HumanPlayer extends Player {

    public HumanPlayer(String vname) {
        super(vname);
    }

    public Move getNextMove() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Move.DOWN;
    }
}

