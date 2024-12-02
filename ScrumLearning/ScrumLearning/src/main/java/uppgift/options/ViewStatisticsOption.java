package uppgift.options;

import uppgift.category.Category;
import uppgift.menu.MenuOption;
import uppgift.statistics.LeaderboardManager;
import uppgift.statistics.LeaderboardMenu;

public class ViewStatisticsOption implements MenuOption {
    LeaderboardManager ld = new LeaderboardManager();
    LeaderboardMenu ldm = new LeaderboardMenu(ld);
    @Override
    public void execute() {
        System.out.println("Viewing your game stats: ");
        ldm.displayMenu();
    }
}
