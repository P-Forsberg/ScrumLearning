package uppgift.options;

import com.fasterxml.jackson.databind.ObjectMapper;
import uppgift.question.Question;
import uppgift.statistics.FileService;

import java.io.*;
import java.util.*;

public class PlayerQuizMaker implements FileService {
    private List<Question> questions;
    private final String filePath = "selfmade_quiz.json";

    public PlayerQuizMaker() {
        this.questions = new ArrayList<>();
        load();
    }

   public void createQuiz(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Numbres of questions you want to create: ");
        int numberOfQuestions = scanner.nextInt();;
        scanner.nextLine();

        for(int i = 0; i < numberOfQuestions; i++){


            System.out.println("Creating question number " + (i+1) + ":");
            System.out.println("Enter question text: ");
            String questionText = scanner.nextLine();

            System.out.println("Enter number of answer options: ");
            int numOptions = scanner.nextInt();
            scanner.nextLine();

            List<String> options = new ArrayList<>();
            for (int j = 0; j < numOptions; j++) {
                System.out.println("Enter option: " + (j + 1) + ":");
                options.add(scanner.nextLine());
            }
            System.out.println("Enter correct answer: ");
            String correctAnswer = scanner.nextLine();

            options.add(correctAnswer);
            Collections.shuffle(options);

            Question question = new Question(questionText, options, correctAnswer, "custom", "custom");;
            questions.add(question);
        }
        save();
    }

    @Override
    public void save() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        try {
            // Spara frågorna som JSON
            objectMapper.writeValue(file, questions);
            System.out.println("Quiz saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save quiz.");
        }
    }

    @Override
    public void load() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        if (file.exists()) {
            try {
                questions = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Question.class));
                System.out.println("Quiz loaded successfully!");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load quiz.");
            }
        } else {
            System.out.println("No saved quiz found.");
        }
    }

    public List<Question> getQuizzes() {
        return questions;
    }
}

