package uppgift.category;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Sport extends CategoryCommand {

    public Sport() {
        super("Sport");
    }

    @Override
    public void executeCategory() {
        System.out.println("Loading category...");
        TriviaAPI();
    }

    public static class TriviaQuestion {
        public String category;
        public String type;
        public String difficulty;
        public String question;
        public String correct_answer;
        public List<String> incorrect_answers;

        @Override
        public String toString() {
            return "Category: " + category +
                    "\nType: " + type +
                    "\nDifficulty: " + difficulty +
                    "\nQuestions: " + question +
                    "\nCorrect Answer: " + correct_answer +
                    "\nIncorrect answers: " + incorrect_answers;
        }
    }

    public static class TriviaResponse {
        public int response_code;
        public List<TriviaQuestion> results;
    }


    public static void TriviaAPI(){
        //public static void execute() {
            String apiUrl = "https://opentdb.com/api.php?amount=12&category=21";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                ObjectMapper objectMapper = new ObjectMapper();
                TriviaResponse triviaResponse = objectMapper.readValue(response.body(), TriviaResponse.class);

                Scanner scanner = new Scanner(System.in);
                int score = 0;

                for (TriviaQuestion question : triviaResponse.results) {
                    System.out.println(question.question);

                    List<String> options = question.incorrect_answers;
                    options.add(question.correct_answer);
                    options.sort((a, b) -> Math.random() < 0.5 ? -1 : 1); // blande alternativen

                    for(int i = 0; i < options.size(); i++){
                        System.out.println((i + 1) + ". " + options.get(i)); // visa alternativen
                    }

                    System.out.println("your Answer (1-" + options.size() + "): ");
                    int answer = scanner.nextInt();

                    if(options.get(answer - 1).equals(question.correct_answer)){
                        System.out.println("Correct!");
                        score ++;
                    } else {
                        System.out.println("Incorrect. the correct answer was: " + question.correct_answer);
                    }
                    System.out.println();
                }
                System.out.println("You answered " + score + " out of " + triviaResponse.results.size() + " questions correctly!");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


