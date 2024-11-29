package uppgift.category;
import uppgift.question.Question;
import uppgift.question.QuestionRepo;
import java.util.List;
import java.util.Scanner;

public class Animals extends Category {

    private uppgift.category.SetQuiz setDifficulty;
    private QuestionRepo questionRepo;
    public String apiUrl;

    public Animals() {
        super("Animals");
        this.questionRepo = new QuestionRepo();
        this.setDifficulty = new uppgift.category.SetQuiz();
        this.apiUrl = "https://opentdb.com/api.php?amount=12&category=27&difficulty=";
    }

    @Override
    public void executeCategory() {
        String diff = setDifficulty.selectDifficulty();
        System.out.println("Loading category...");
        questions = questionRepo.TriviaAPI(apiUrl + diff);
        for(int i = 0; i < questions.size(); i++) System.out.println(questions.get(i));
    }
}