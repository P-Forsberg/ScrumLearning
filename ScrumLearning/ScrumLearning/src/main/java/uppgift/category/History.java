package uppgift.category;

import uppgift.Statistics.StatisticSaver.FileStatisticSaver;


import uppgift.Statistics.StatisticManager;
import uppgift.question.Question;
import uppgift.question.QuestionRepo;
import java.util.List;
import java.util.Scanner;

public class History extends CategoryCommand{

    private SetQuiz setDifficulty;
    private QuestionRepo questionRepo;
    public String apiUrl;
    private StatisticManager statisticManager;
    private FileStatisticSaver statisticSaver;


    public History() {
        super("History");
        this.questionRepo = new QuestionRepo();
        this.setDifficulty = new SetQuiz();
        this.apiUrl = "https://opentdb.com/api.php?amount=12&category=23&difficulty=";
        this.statisticSaver = new FileStatisticSaver("statistics.txt");
        this.statisticManager = new StatisticManager();
    }

    private void handleQuiz(List<Question> historyQuestions) {
        Scanner scanner = new Scanner(System.in);

        int score = 0;
        int questionsAttempted = 0;
        int correctAnswers = 0;

        for (Question question : historyQuestions) {
            System.out.println("Question: " + question.getQuestion());
            for (int i = 0; i < question.getAllAnswers().size(); i++){
                System.out.println((i + 1) + ". " + question.getAllAnswers().get(i));
            }
            System.out.println(question.getDifficulty());
            int answer = scanner.nextInt() -1;

            System.out.println(question.getAllAnswers().get(answer));
            System.out.println("--------------------------");
            questionsAttempted++;
            if(question.getAllAnswers().get(answer).equals(question.getCorrectAnswer())){
                System.out.println("Correct");
                correctAnswers++;
                statisticManager.updateStats(true);
            } else{
                System.out.println("Wrong");
            }
        }

        double accuracy = (questionsAttempted > 0) ? ((double) correctAnswers / questionsAttempted) * 100 : 0;

        // Skriv ut och spara statistik
        System.out.println("Quiz Completed!");
        System.out.println("Score: " + statisticManager.getScore());
        System.out.println("Correct Answers: " + correctAnswers + "/" + questionsAttempted);
        System.out.printf("Accuracy: %.2f%%\n", accuracy);

        // Anropa StatisticSaver för att spara till fil
        statisticSaver.saveStatistics("Player1", statisticManager.getScore(), questionsAttempted, correctAnswers, accuracy);

    }

    @Override
    public void executeCategory() {
        System.out.println("Loading category...");
        String diff = setDifficulty.selectDifficulty();
        List<Question> historyQuestions = questionRepo.TriviaAPI(apiUrl + diff);
        handleQuiz(historyQuestions);
    }

}