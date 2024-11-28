package uppgift.Statistics;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private String username;
    private static Set<String> registeredUsernames = new HashSet<>();
    private StatisticManager statisticManager;
    private StatisticSaver statisticSaver;

    public Player(String username, StatisticSaver statisticSaver) {
        if (isUsernameTaken(username)) {
            throw new IllegalArgumentException("Username already taken.");
        }
        this.username = username;
        registeredUsernames.add(username);
        this.statisticManager = new StatisticManager();
        this.statisticSaver = statisticSaver;
    }

    public static boolean isUsernameTaken(String username) {
        return registeredUsernames.contains(username);
    }

    public String getUsername() {
        return username;
    }

    public StatisticManager getStatisticManager() {
        return statisticManager;
    }

    public void updateStatistics(boolean isCorrect) {
        statisticManager.updateStats(isCorrect);
    }

    public void saveStatistics() {
        if (statisticSaver != null) {
            statisticSaver.saveStatistics(
                    getUsername(),
                    statisticManager.getScore(),
                    statisticManager.getQuestionsAttempted(),
                    statisticManager.getCorrectAnswers(),
                    statisticManager.calculateAccuracy()
            );
        }
    }

    public void displayStatistics() {
        statisticManager.displayStatistics(getUsername());
    }
}

