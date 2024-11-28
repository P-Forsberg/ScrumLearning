package uppgift.category;

import uppgift.question.Question;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {
    private String name;
    protected List<Question> questions;

    public Category(String name){
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public abstract void executeCategory();
    public List<Question> getQuestions() {
        return questions;
    }
}
