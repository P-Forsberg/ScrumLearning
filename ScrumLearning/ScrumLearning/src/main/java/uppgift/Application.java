package uppgift;

import uppgift.question.Question;
import uppgift.question.QuestionRepo;

import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {

        QuestionRepo repo = new QuestionRepo();
        List<Question> questions;
        try {
            questions = repo.fetchQuestions();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       List <Question> filtered = repo.getFilteredQuestion(questions, "Sports", "easy");

        for (Question q : questions) {
            System.out.println("alla frågor: " +  q.getCategory() + " " + q.getDifficulty());

        }
        for(Question q : filtered) {
            System.out.println("filtered : " + q.getQuestion());
        }

    }
}