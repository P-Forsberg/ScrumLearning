package options;

import menu.MenuOption;

public class PlayGameOption implements MenuOption {
    @Override
    public void execute() {
        System.out.println("Starting the quiz!");
    }
}
