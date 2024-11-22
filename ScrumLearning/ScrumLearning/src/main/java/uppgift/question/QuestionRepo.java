package uppgift.question;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringEscapeUtils;



public class QuestionRepo {
        public List<Question> TriviaAPI(String api) {
            List<Question> questions = new ArrayList<>();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(api))
                    .GET()
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> responseMap= objectMapper.readValue(response.body(), Map.class);

                List<Map<String, Object>> res = (List<Map<String, Object>>) responseMap.get("results");

                for (Map<String, Object> triviaQuestion : res) {

                    String questionText = StringEscapeUtils.unescapeHtml4((String)triviaQuestion.get("question"));
                    String correctAnswer =  StringEscapeUtils.unescapeHtml4((String)triviaQuestion.get("correct_answer"));
                    String diff = (String) triviaQuestion.get("difficulty");
                    String cat = (String) triviaQuestion.get("category");
                    List<String> incorrectAnswers = (List <String>) triviaQuestion.get("incorrect_answers");

                    List <String> options = new ArrayList<>(incorrectAnswers);
                    options.add(correctAnswer);

                    Question question = new Question(questionText, options, correctAnswer, diff, cat);
                    questions.add(question);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            return questions;
        }
    }