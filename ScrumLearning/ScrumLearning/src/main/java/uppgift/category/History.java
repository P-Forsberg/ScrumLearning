package uppgift.category;

import uppgift.question.Question;
import uppgift.question.QuestionRepo;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class History extends CategoryCommand{

    private QuestionRepo questionRepo;
    public String apiUrl;

    public History() {
        super("History");
        this.questionRepo = new QuestionRepo();
        this.apiUrl = "https://opentdb.com/api.php?amount=12&category=23";
    }

    private void handleQuiz(List<Question> historyQuestions) {
        Scanner scanner = new Scanner(System.in);
        for (Question question : historyQuestions) {
            System.out.println("Question: " + question.getQuestion());
            for (int i = 0; i < question.getAllAnswers().size(); i++){
                System.out.println((i + 1) + ". " + question.getAllAnswers().get(i));
            }
            System.out.println(question.getCorrectAnswer());
            int answer = scanner.nextInt() -1;
            System.out.println(question.getAllAnswers().get(answer));
            System.out.println("--------------------------");
            if(question.getAllAnswers().get(answer).equals(question.getCorrectAnswer())){
                System.out.println("Correct");
            } else{
                System.out.println("Wrong");
            }
        }
    }
    @Override
    public void executeCategory() {
        System.out.println("Loading category...");
        List<Question> historyQuestions = questionRepo.TriviaAPI(apiUrl);
        handleQuiz(historyQuestions);
    }

}

