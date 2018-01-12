package fr.mg.model;

public class Player {

    private int position;
    private String name;

    public int treasureCount;


    public Player(String vname){
        name = vname;
        position = 0;
        treasureCount = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
}