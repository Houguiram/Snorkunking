public class Chest {

    private int treasureCount;

    public Chest(int vtreasureCount) {
        treasureCount = vtreasureCount;
    }

    public int getTreasureCount() {
        return treasureCount;
    }

    public void setTreasureCount(int vtreasureCount) {
        this.treasureCount = vtreasureCount;
    }

    public void openChest(Player player) {
        player.treasureCount += treasureCount;
    }

}