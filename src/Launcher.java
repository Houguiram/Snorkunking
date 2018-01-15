import fr.mg.model.Game;
import fr.mg.vue.IHM;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("Lancement du jeu");
        Game game = new Game();
        IHM vue = new IHM(game);

    }

}