package uppgift.options;

import uppgift.menu.MenuOption;
import uppgift.statistics.Player;

public class ViewStatisticsOption implements MenuOption {

    @Override
    public void execute(Player currentPlayer) {
       currentPlayer.displayStatistics();
    }
}
