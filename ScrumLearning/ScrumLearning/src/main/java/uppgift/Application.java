package uppgift;
import uppgift.menu.Menu;
import uppgift.participant.ParticipantGame;
import uppgift.user.UserManager;


public class Application {

    public static void main(String[] args){

    Menu menu = new Menu();
    UserManager userManager = new UserManager();
    userManager.start();
    ParticipantGame pg = new ParticipantGame();
    pg.displayWelcomeMessage();
    pg.handleMenuSelection();
    menu.displayMenu();
  }
}
