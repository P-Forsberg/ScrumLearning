package uppgift;

import uppgift.category.Sport;
import uppgift.menu.Menu;
import uppgift.user.UserManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {

        //Menu menu = new Menu();
        //menu.displayMenu();
        UserManager userManager = new UserManager();
        userManager.start();
    }
}