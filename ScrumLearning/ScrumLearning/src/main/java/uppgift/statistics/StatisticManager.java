package uppgift.statistics;

import java.util.HashMap;
import java.util.Map;

public class StatisticManager {
    private int score;
    private int questionsAttempted;
    private int correctAnswers;
    private Map<String, int[]> categoryStats; // Nytt: Statistik per kategori

    public StatisticManager() {
        this.score = 0;
        this.questionsAttempted = 0;
        this.correctAnswers = 0;
        this.categoryStats = new HashMap<>();
    }

    public void updateStats(boolean isCorrect, String category) {
        questionsAttempted++;
        if (isCorrect) {
            correctAnswers++;
            score += 10;
        }

        // Uppdatera statistik för kategorin
        categoryStats.putIfAbsent(category, new int[]{0, 0});
        int[] stats = categoryStats.get(category);
        stats[0] += isCorrect ? 1 : 0; // Rätt svar
        stats[1]++; // Försök
        categoryStats.put(category, stats);
    }

    public Map<String, int[]> getCategoryStats() {
        return categoryStats;
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

        System.out.println("Category Statistics:");
        categoryStats.forEach((category, stats) -> {
            double accuracy = stats[1] > 0 ? (stats[0] / (double) stats[1]) * 100 : 0.0;
            System.out.printf("%s: %d/%d (%.2f%%)\n", category, stats[0], stats[1], accuracy);
        });
        System.out.println("-----------------------");
    }
}
