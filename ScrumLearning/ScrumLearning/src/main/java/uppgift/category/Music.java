package uppgift.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import uppgift.question.Question;
import uppgift.question.QuestionRepo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Music extends CategoryCommand {

    private SetQuiz setDifficulty;
    private QuestionRepo questionRepo;
    private String apiUrl;

    public Music() {
        super("Music");
        this.questionRepo = new QuestionRepo();
        this.setDifficulty = new SetQuiz();
        this.apiUrl = "https://opentdb.com/api.php?amount=12&category=12&difficulty=";
    }

    private void handleQuiz(List<Question> musicQuestions) {
        Scanner scanner = new Scanner(System.in);
        for (Question question : musicQuestions) {
            System.out.println("Question: " + question.getQuestion());
            for (int i = 0; i < question.getAllAnswers().size(); i++) {
                System.out.println((i + 1) + ". " + question.getAllAnswers().get(i));
            }

            int answer = scanner.nextInt() - 1;
            System.out.println(question.getAllAnswers().get(answer));
            System.out.println("--------------------------");
            if (question.getAllAnswers().get(answer).equals(question.getCorrectAnswer())) {
                System.out.println("correct");
            } else {
                System.out.println("wrong");
            }
        }
    }

    @Override
    public void executeCategory() {
        String diff = setDifficulty.selectDifficulty();
        System.out.println("Loading category...");
        List<Question> musicQuestions = questionRepo.TriviaAPI(apiUrl + diff);
        handleQuiz(musicQuestions);

    }
}
