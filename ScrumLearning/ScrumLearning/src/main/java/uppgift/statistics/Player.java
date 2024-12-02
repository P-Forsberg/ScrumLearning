package uppgift.statistics;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String username;
    private StatisticManager statisticManager;

    public Player(String username) {
        this.username = username;
        this.statisticManager = new StatisticManager();
    }
    // Jackson
    public Player(){}

    public String getUsername() {
        return username;
    }

    public StatisticManager getStatisticManager() {
        return statisticManager;
    }

    public void updateStatistics(boolean isCorrect) {
        statisticManager.updateStats(isCorrect);
    }

    public void displayStatistics() {
        statisticManager.displayStatistics(getUsername());
    }

}