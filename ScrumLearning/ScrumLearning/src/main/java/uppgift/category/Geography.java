package uppgift.category;

import uppgift.question.Question;
import uppgift.question.QuestionRepo;
import java.util.List;
import java.util.Scanner;

public class Geography extends CategoryCommand{
    private SetQuiz setDifficulty;
    private QuestionRepo questionRepo;
    public String apiUrl;

    public Geography() {
        super("Geography");
        this.setDifficulty = new SetQuiz();
        this.questionRepo = new QuestionRepo();
        this.apiUrl = "https://opentdb.com/api.php?amount=12&category=22&difficulty=";
    }


   /* public static void TriviaAPI(String difficulty){
        String apiUrl = "https://opentdb.com/api.php?amount=12&category=22&difficulty=" + difficulty;*/

        private void handleQuiz(List< Question > geographyQuestions) {
            Scanner scanner = new Scanner(System.in);
            for (Question question : geographyQuestions) {
                System.out.println("Question: " + question.getQuestion());
                for (int i = 0; i < question.getAllAnswers().size(); i++){
                    System.out.println((i + 1) + ". " + question.getAllAnswers().indexOf(i));
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
            List<Question> geographyQuestions = questionRepo.TriviaAPI(apiUrl);
            handleQuiz(geographyQuestions);
        }

    }