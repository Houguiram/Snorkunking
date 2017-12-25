import fr.mg.model.Game;
import fr.mg.vue.IHM;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("Lancement du jeu");
        Game game = new Game();
        game.init(1);
        IHM vue = new IHM(game.getCavesSizes()[0], game.getCavesSizes()[1], game.getCavesSizes()[2]);


    }

}