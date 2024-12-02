package uppgift.statistics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StatisticManager {
    private int score;
    private int questionsAttempted;
    private int correctAnswers;
    private Map<String, int[]> categoryStats;

    public StatisticManager() {
        score = 0;
        questionsAttempted = 0;
        correctAnswers = 0;
        this.categoryStats = new HashMap<>();
    }

    public void updateStats(boolean isCorrect) {
        questionsAttempted++;
        if (isCorrect) {
            correctAnswers++;
            score += 10;
        }
    }

    public int getScore() {
        return score;
    }

    public int getQuestionsAttempted() {
        return questionsAttempted;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public double calculateAccuracy() {
        if (questionsAttempted == 0) {
            return 0.0;
        }
        return ((double) correctAnswers / questionsAttempted) * 100;
    }

    public void displayStatistics(String playerName) {
        System.out.println("Statistics for " + playerName + ":");
        System.out.println("Score: " + score);
        System.out.println("Questions Attempted: " + questionsAttempted);
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.printf("Accuracy: %.2f%%\n", calculateAccuracy());
        System.out.println("-----------------------");
    }

    public void displayCategoryStatistics(String playerName) {
        System.out.println("Category Statistics for " + playerName + ":");
        for (Map.Entry<String, int[]> entry : categoryStats.entrySet()) {
            String category = entry.getKey();
            int[] stats = entry.getValue();
            double accuracy = stats[1] > 0 ? ((double) stats[0] / stats[1]) * 100 : 0.0;
            System.out.printf("Category: %s - Correct Answers: %d/%d (%.2f%%)\n", category, stats[0], stats[1], accuracy);
        }
        System.out.println("-----------------------");
    }
}
