package main.java.uppgift.AvslutaAppen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import main.java.uppgift.saveandload.SaveAndLoad;

public class FileManager implements SaveAndLoad {
    // En lista med data. 
    private List<String> quizQuestions; 

    public FileManager() {
        // 
        
    }

    @Override
    public void saveQuiz() throws IOException {
        spara quiz
        saveFile();
    }

    public void saveFile() throws IOException {
               String filename = "quiz.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String question : quizQuestions) {
                writer.write(question); // Skriver varje fråga till filen
                writer.newLine(); // 
            }
        }
        
        System.out.println("Quizet har sparats till " + filename);
    }
}