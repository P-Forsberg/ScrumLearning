package uppgift.Statistics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatisticManager {
    private int score;
    private int questionsAttempted;
    private int correctAnswers;

    public StatisticManager() {
        this.score = 0;
        this.questionsAttempted = 0;
        this.correctAnswers = 0;
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

    public void loadStatistics(String playerName){
        File file = new File("statistics.txt");

        if(!file.exists()){
            System.out.println("Stats not found.");
            return;
        }
        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.contains(playerName)){
                    System.out.println("loaded stats for " + playerName + ": " + line);
                    return;
                }
            }
        } catch (IOException e){
            System.out.println("error reading file: " + e.getMessage());
        }
        System.out.println("No statistics found for player: " + playerName);
    }

    public void displayStatistics(String playerName) {
            loadStatistics(playerName);

            System.out.println("Statistics for " + playerName + ":");
            System.out.println("Score: " + score);
            System.out.println("Questions Attempted: " + questionsAttempted);
            System.out.println("Correct Answers: " + correctAnswers);
            System.out.printf("Accuracy: %.2f%%\n", calculateAccuracy());
            System.out.println("-----------------------");
        }
    }
// 27/11 cecilia - leaderboard fixad igår, idag pussla ihop koden.
// josef - försökte pussla ihop igår, fix ihop vissa delar.
// anton - försätta som igår och sätta ihop delarna.
// olga - ändringar igår, la till boolean i Application, fundera på vad sim finns och göra.
// pontus - fått statistik och funka igår med poäng, idag få utskrift på statistik.

// josef hade lite problem med "mark as source root", och skulle kolla på det efter avslutat möte.
//

