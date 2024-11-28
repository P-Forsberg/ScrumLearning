package uppgift;
import uppgift.menu.Menu;
import uppgift.participant.ParticipantGame;
import uppgift.user.UserManager;


public class Application {

    public static void main(String[] args){

    ParticipantGame pg = new ParticipantGame();
    UserManager userManager = new UserManager();
    Game game = new Game();


    userManager.start();
    pg.displayWelcomeMessage();
    pg.handleMenuSelection();
    game.game();
  }
}