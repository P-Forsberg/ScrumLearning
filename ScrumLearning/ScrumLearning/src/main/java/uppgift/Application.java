package uppgift;
import uppgift.menu.Menu;
import uppgift.statistics.Player;
import uppgift.user.UserManager;


public class Application {

    public static void main(String[] args){

        Menu menu = new Menu();
        UserManager userManager = new UserManager();
        while(true) {
            Player currp = userManager.start();
            if (currp == null) break;

            Game game = new Game(currp);
            game.game();
        }
    }
}