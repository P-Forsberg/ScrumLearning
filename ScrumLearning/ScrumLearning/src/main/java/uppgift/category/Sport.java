package uppgift.category;
import com.fasterxml.jackson.databind.ObjectMapper;
import uppgift.question.Question;
import uppgift.question.QuestionRepo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Sport extends CategoryCommand {
    private QuestionRepo questionRepo;
    private String apiUrl;

    public Sport() {
        super("Sport");
        this.questionRepo = new QuestionRepo();
        this.apiUrl = "https://opentdb.com/api.php?amount=12&category=21";
    }

    private void handleQuiz(List<Question> sportQuestions) {
        Scanner scanner = new Scanner(System.in);
        for (Question question : sportQuestions) {
            System.out.println("Question: " + question.getQuestion());
            for (int i = 0; i < question.getAllAnswers().size(); i++){
                System.out.println((i + 1) + ". " + question.getAllAnswers().get(i));
            }

            System.out.println(question.getCorrectAnswer());
            int answer = scanner.nextInt() -1;
            System.out.println(question.getAllAnswers().get(answer));
            System.out.println("--------------------------");
            if (question.getAllAnswers().get(answer).equals(question.getCorrectAnswer())){
                System.out.println("correct");
            } else {
                System.out.println("wrong");
            }
        }
    }

    @Override
    public void executeCategory() {
        System.out.println("Loading category...");
        List <Question> sportQuestions  = questionRepo.TriviaAPI(apiUrl);
        handleQuiz(sportQuestions);
    }
}


