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
        statisticManager.loadStatistics("Player1");


        statisticManager.displayStatistics("Player2");

    }

}
