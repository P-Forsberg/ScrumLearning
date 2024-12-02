package uppgift.options;

import uppgift.menu.MenuOption;
import uppgift.statistics.LeaderboardManager;
import uppgift.statistics.LeaderboardMenu;

import java.lang.reflect.Member;

public class LeaderBoardOption implements MenuOption {
    LeaderboardManager ld = new LeaderboardManager();
    LeaderboardMenu ldm = new LeaderboardMenu(ld);
    @Override
    public void execute() {
        System.out.println("Viewing your game stats: ");
        ldm.displayMenu();
    }
}
