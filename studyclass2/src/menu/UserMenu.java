package menu;

import command.LogoutCommand;
import main.Application;

public class UserMenu extends Menu {


    public UserMenu(Application application) {
        super(application);

        addCommand(new LogoutCommand(application));
    }

    @Override
    public void present() {
        System.out.println("Welcome, here are your choices: ");
        System.out.println(" - loan <book>");

    }
}
