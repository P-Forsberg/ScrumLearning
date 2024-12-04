package uppgift.statistics;

import uppgift.PrintUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StatisticManager {
    private int score;
    private int questionsAttempted;
    private int correctAnswers;

    public StatisticManager() {
        score = 0;
        questionsAttempted = 0;
        correctAnswers = 0;
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
        System.out.println(PrintUtil.YELLOW + "Statistics for " + playerName + ":");
        System.out.println("Score: " + score);
        System.out.println("Questions Attempted: " + questionsAttempted);
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.printf("Accuracy: %.2f%%\n", calculateAccuracy());
        System.out.println("-----------------------");
    }
}
