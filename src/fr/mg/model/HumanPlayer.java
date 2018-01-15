package fr.mg.model;

public class HumanPlayer extends Player {

    public HumanPlayer(String vname) {
        super(vname);
    }

    public Move getNextMove() {
        return Move.DOWN;
    }
}

