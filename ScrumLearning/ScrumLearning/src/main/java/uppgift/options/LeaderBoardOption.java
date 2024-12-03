package uppgift.options;

import uppgift.menu.MenuOption;
import uppgift.statistics.LeaderboardManager;
import uppgift.statistics.LeaderboardMenu;
import uppgift.statistics.Player;

public class LeaderBoardOption implements MenuOption {
    LeaderboardManager ld = new LeaderboardManager();
    LeaderboardMenu ldm = new LeaderboardMenu(ld);
    @Override
    public void execute(Player currentPlayer) {
        System.out.println("Viewing your game stats: ");
        ldm.displayMenu();
    }
}
