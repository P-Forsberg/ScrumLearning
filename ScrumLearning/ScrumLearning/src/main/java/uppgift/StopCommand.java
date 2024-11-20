package main.java.uppgift;

import java.io.IOException;
import saveandload.SaveAndLoad;

public class StopCommand implements SaveAndLoad {
    private Application application;

    public StopCommand(Application application) {
        this.application = application;
    }
    
    @Override
    public void saveQuiz() throws IOException {
        // jag kan lägga till kod för att spara quiz här
        System.out.println("Sparar quiz...");
        // jag kan lägga till kod för att spara till en fil
    }

    @Override
    public void loadQuiz() throws IOException {
        // Implementera logik för att ladda quiz här
        System.out.println("Laddar quiz...");
        // jag kan lägga till kod för att ladda från en fil
    }

    public void run(String[] args) {
        try {
            saveQuiz();
            // Stäng av programmet.
            // application.running = false; // jag behöver lägga till variabeln 'running' i Application
        } catch (IOException e) {
            System.err.println("Ett fel uppstod vid sparning: " + e.getMessage());
        }
    }
}