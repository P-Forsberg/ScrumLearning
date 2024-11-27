package uppgift;


import uppgift.menu.Menu;
import uppgift.user.UserManager;

public class Application {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.start();
        //Menu menu = new Menu();
        //menu.displayMenu();

    }
}