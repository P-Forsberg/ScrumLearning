package uppgift.statistics;


public interface StatisticSaver {
    void saveStatistics(String playerName, int score, int questionsAttempted, int correctAnswers, double accuracy);
}
