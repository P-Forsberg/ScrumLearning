package uppgift.score;

public class ScoreManager {
    private int score;
    private int totalQuestions;

    public ScoreManager() {
        this.score = 0;
        this.totalQuestions = 0;
    }

    public void incrementScore() {
        this.score++;
    }

    public void incrementTotalQuestions() {
        this.totalQuestions++;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void reset() {
        this.score = 0;
        this.totalQuestions = 0;
    }

    public void displayCurrentScore() {
        System.out.println("Your current score: " + score + "/" + totalQuestions);
    }
}
