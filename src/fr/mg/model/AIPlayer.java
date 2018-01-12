package fr.mg.model;

public class AIPlayer extends Player {

    public AIPlayer(String vname) {
        super(vname);
    }

    @Override
    public Move getNextMove() {
        return Move.DOWN;
    }
}