package uppgift.options;

import uppgift.menu.MenuOption;

public class ViewStatisticsOption implements MenuOption {
    @Override
    public void execute() {
        System.out.println("Viewing your game stats: ");
    }

}