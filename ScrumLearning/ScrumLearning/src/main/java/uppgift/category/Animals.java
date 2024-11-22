package uppgift.category;
import uppgift.question.Question;
import uppgift.question.QuestionRepo;
import java.util.List;
import java.util.Scanner;

public class Animals extends CategoryCommand {

    private SetQuiz setDifficulty;
    private QuestionRepo questionRepo;
    public String apiUrl;

    public Animals() {
        super("Animals");
        this.questionRepo = new QuestionRepo();
        this.setDifficulty = new SetQuiz();
        this.apiUrl = "https://opentdb.com/api.php?amount=12&category=27&difficulty=";
    }


        private void handleQuiz(List< Question > animalQuestions) {
            Scanner scanner = new Scanner(System.in);
            for (Question question : animalQuestions) {
                System.out.println("Question: " + question.getQuestion());
                for (int i = 0; i < question.getAllAnswers().size(); i++){
                    System.out.println((i + 1) + ". " + question.getAllAnswers().get(i));
                }
                System.out.println(question.getDifficulty());
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
            String diff = setDifficulty.selectDifficulty();
            List<Question> animalQuestions = questionRepo.TriviaAPI(apiUrl + diff);
            handleQuiz(animalQuestions);
        }