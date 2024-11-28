package uppgift.category;

import uppgift.question.Question;
import uppgift.question.QuestionRepo;
import java.util.List;

public class History extends Category{

    private SetQuiz setDifficulty;
    private QuestionRepo questionRepo;
    public String apiUrl;

    public History() {
        super("History");
        this.questionRepo = new QuestionRepo();
        this.setDifficulty = new SetQuiz();
        this.apiUrl = "https://opentdb.com/api.php?amount=2&category=23&difficulty=";
    }

    @Override
    public void executeCategory() {
        String diff = setDifficulty.selectDifficulty();
        System.out.println("Loading category...");
        questions = questionRepo.TriviaAPI(apiUrl + diff);
    }
}