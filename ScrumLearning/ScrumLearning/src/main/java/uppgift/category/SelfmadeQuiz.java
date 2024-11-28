package uppgift.category;


import uppgift.options.PlayerQuizMaker;

import uppgift.score.ScoreManager;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class SelfmadeQuiz extends Category {
    private PlayerQuizMaker quizMaker;
    private ScoreManager scoreManager;

    public SelfmadeQuiz() {
        super("Selfmade Quiz");
        quizMaker = new PlayerQuizMaker();
        scoreManager = new ScoreManager();

        try {
            quizMaker.loadQuiz();
        } catch (IOException e) {
            System.out.println("Failed to load selfmade quizzes: " + e.getMessage());
        }
    }

    @Override
    public void executeCategory() {
        if (quizMaker.getQuizzes().isEmpty()) {
            System.out.println("No selfmade quizzes available. Please create on first.");
            return;
        }

        scoreManager.reset();

        Random random = new Random();
        int quizIndex = random.nextInt(quizMaker.getQuizzes().size());

        List<String> questions = quizMaker.getQuizzes().get(quizIndex);
        List<String> answer = quizMaker.getAnswers().get(quizIndex);

        System.out.println("Starting a selfmade quiz!");
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i+ 1) + ": " + questions.get(i));
            String userAnswer = scanner.nextLine();

            scoreManager.incrementTotalQuestions();

            if (userAnswer.equalsIgnoreCase(answer.get(i))) {
                System.out.println("Correct!");
                scoreManager.incrementScore();
            } else {
                System.out.println("Wrong! The correct answer was: " + answer.get(i));
            }

            scoreManager.displayCurrentScore();
        }
        System.out.println("Quiz finished! Your final score: " + scoreManager.getScore() + "/" + scoreManager.getTotalQuestions());
        System.out.println();
    }
}
