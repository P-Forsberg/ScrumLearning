package uppgift;
import uppgift.menu.Menu;
import uppgift.participant.ParticipantGame;
import uppgift.user.UserManager;


public class Application {

    public static void main(String[] args){

    Menu menu = new Menu();
    ParticipantGame pg = new ParticipantGame();
    UserManager userManager = new UserManager();


    userManager.start();
    pg.displayWelcomeMessage();
    pg.handleMenuSelection();
    menu.displayMenu();
  }
}