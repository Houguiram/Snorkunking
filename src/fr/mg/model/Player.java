package fr.mg.model;

public class Player {

    private int position;

    public int treasureCount;


    public Player(){
        position = 0;
        treasureCount = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}