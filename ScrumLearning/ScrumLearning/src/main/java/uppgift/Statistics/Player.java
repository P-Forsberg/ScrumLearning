package uppgift.Statistics;

import uppgift.user.Users;

public class Player {
    private Users user;
    private StatisticManager statisticManager;
    private StatisticSaver statisticSaver;

    public Player(String username, StatisticSaver statisticSaver) {
        this.user = new Users(username);
        this.statisticManager = new StatisticManager();
        this.statisticSaver = statisticSaver;
    }

    public String getUsername() {
        return user.getUsername();
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

