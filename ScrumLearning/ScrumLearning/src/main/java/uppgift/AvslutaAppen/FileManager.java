// package main.java.uppgift.AvslutaAppen;

// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.util.ArrayList;
// import java.util.List;

// import main.java.uppgift.saveandload.SaveAndLoad;

// public class FileManager implements SaveAndLoad {
//     @Override
//     public void saveFile() throws IOException {
//         // jag kan lägga till kod för att spara quiz här
//         System.out.println("Sparar quiz...");
//         // jag kan lägga till kod för att spara till en fil
//     }

// }
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