package fr.mg.model;

import java.util.concurrent.TimeUnit;

public class HumanPlayer extends Player {

    public HumanPlayer(String vname) {
        super(vname);
    }

    public Move getNextMove(int input) {
        switch (input){
            case 38 :
                return Move.UP;
            case 40 :
                return Move.DOWN;
            case 32 :
                return Move.PICKUP;

                default:
                    return Move.NONE;
        }
    }
}

