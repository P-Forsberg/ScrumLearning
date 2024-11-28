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

public class Music extends Category {

    private SetQuiz setDifficulty;
    private QuestionRepo questionRepo;
    private String apiUrl;

    public Music() {
        super("Music");
        this.questionRepo = new QuestionRepo();
        this.setDifficulty = new SetQuiz();
        this.apiUrl = "https://opentdb.com/api.php?amount=12&category=12&difficulty=";
    }


    @Override
    public void executeCategory() {
        String diff = setDifficulty.selectDifficulty();
        System.out.println("Loading category...");
        questions = questionRepo.TriviaAPI(apiUrl + diff);
    }
}
