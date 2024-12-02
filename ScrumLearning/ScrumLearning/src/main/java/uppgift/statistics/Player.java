package uppgift.statistics;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String username;
    private StatisticManager statisticManager;
    private StatisticSaver statisticSaver;

    public Player(String username) {
        this.username = username;
        this.statisticManager = new StatisticManager();
    }
    // för jackson
    public Player(){
    }
    public String getUsername() {
        return username;
    }

    public StatisticManager getStatisticManager() {
        return statisticManager;
    }

    public void updateStatistics(boolean isCorrect, String cat) {
        statisticManager.updateStats(isCorrect, cat);
    }

    public void displayStatistics() {
        statisticManager.displayStatistics(getUsername());
    }
    public void saveStatistics() {
        statisticManager.saveStatistics(
                getUsername(),
                statisticManager.getScore(),
                statisticManager.getQuestionsAttempted(),
                statisticManager.getCorrectAnswers(),
                statisticManager.calculateAccuracy()
        );
    }
}