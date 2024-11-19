package uppgift.question;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class QuestionRepo {
    private final String API_url = "https://opentdb.com/api.php?amount=50&type=multiple";

    public List<Question> fetchQuestions() throws IOException, InterruptedException {
        List<Question> questions = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(API_url))
                .build();

        HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseB = response.body();

            JSONObject jsonResponse = new JSONObject(responseB);
            JSONArray res = jsonResponse.getJSONArray("results");

            for (int i = 0; i < res.length(); i++) {
                JSONObject jsonQuestion = res.getJSONObject(i);
                // get data from the json
                String questionText = jsonQuestion.getString("question");
                String correctAnswer = jsonQuestion.getString("correct_answer");
                String questionCategory = jsonQuestion.getString("category");
                String questionDifficulty = jsonQuestion.getString("difficulty");
                JSONArray incorrectAnswers  = jsonQuestion.getJSONArray("incorrect_answers");

                List<String> allAnswers = new ArrayList<>();
                allAnswers.add(correctAnswer);
                for (int j = 0; j < incorrectAnswers.length(); j++){
                    allAnswers.add(incorrectAnswers.getString(j));
                }
                Question question = new Question(questionText, correctAnswer, allAnswers, questionDifficulty, questionCategory);
                questions.add(question);
            }
        }
        return questions;
    }

    public List<Question> getFilteredQuestion(List<Question> questions, String category, String difficulty) {
        return questions.stream()
                .filter(q -> q.getCategory().equals(category))
                .filter(q -> q.getDifficulty().equals(difficulty))
                .toList();

    }
}