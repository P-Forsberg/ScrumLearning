package uppgift.options;

import uppgift.menu.MenuOption;
import uppgift.Statistics.StatisticManager;

public class ViewStatisticsOption implements MenuOption {
    private StatisticManager statisticManager;

    public ViewStatisticsOption(){
        this.statisticManager = new StatisticManager();
    }

    @Override
    public void execute() {
        System.out.println("Viewing your game stats: ");
        statisticManager.displayStatistics("Player1");
    }

}
