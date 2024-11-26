package uppgift.Statistics;

public class Player {
    private String name;
    private StatisticManager statisticManager;
    private StatisticSaver statisticSaver;

    public Player(String name, StatisticSaver statisticSaver) {
        this.name = name;
        this.statisticManager = new StatisticManager();
        this.statisticSaver = statisticSaver;
    }

    public String getName() {
        return name;
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
                    name,
                    statisticManager.getScore(),
                    statisticManager.getQuestionsAttempted(),
                    statisticManager.getCorrectAnswers(),
                    statisticManager.calculateAccuracy()
            );
        }
    }

    public void displayStatistics() {
        statisticManager.displayStatistics(name);
    }
}
