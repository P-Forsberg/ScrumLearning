package uppgift;
import uppgift.menu.Menu;
import uppgift.menu.MenuOption;
import uppgift.participant.ParticipantGame;
import uppgift.user.UserManager;
import uppgift.user.Users;


public class Application {

    public static void main(String[] args){

    Menu menu = new Menu();
    ParticipantGame pg = new ParticipantGame();
    UserManager userManager = new UserManager();


    userManager.start();
    pg.displayWelcomeMessage();
    pg.handleMenuSelection();
    int choice = menu.displayMenu();
    MenuOption option[] = menu.getOptions();
    if (choice < option.length && choice > 0) option[choice -1].execute();

    // skapar alla dependecieys
        // 1. akriv spelare = loginmenu
        
        // 2. antal deltgare = delatqagar meny
        // 3. huvud meny val = huvudmeny
        // 4. spela categorie = huvud meny val
        // 5. tillbaka till 3
  }
}