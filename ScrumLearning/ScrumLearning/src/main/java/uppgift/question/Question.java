package uppgift.question;

import java.util.List;

public class Question {
    private String question;
    private List<String> allAnswers;
    private String correctAnswer;
    private String difficulty;
    private String category;


    public Question(String question, List<String> allAnswers, String correctAnswer, String difficulty, String category) {
        this.question = question;
        this.allAnswers = allAnswers;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
        this.category = category;
    }
    public Question(){}

    public String getQuestion() {
        return question;
    }

    public String getCategory() {
        return category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getAllAnswers() {
        return allAnswers;
    }
}

