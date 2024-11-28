package uppgift;
import uppgift.menu.Menu;
import uppgift.participant.ParticipantGame;
import uppgift.statistics.Player;
import uppgift.user.UserManager;


public class Application {

    public static void main(String[] args){

    UserManager userManager = new UserManager();
    Player currp = null;

    currp = userManager.start();
    Game game = new Game(currp);
    game.game();
  }
}