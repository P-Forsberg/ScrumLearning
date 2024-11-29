/*
package main.java.uppgift.AvslutaAppen;

import java.io.IOException;

import main.java.uppgift.Application;

public class StopCommand {
    private Application application;

    public StopCommand(Application application) {
        this.application = application;
    }

    public void run(String[] args) {
        try {
            FileManager fileManager = new FileManager();
            fileManager.saveFile(); // Anropar metoden för att spara filen
            application.running = false; // Stänger av programmet.
        } catch (IOException e) {
            System.err.println("Ett fel uppstod vid sparning: " + e.getMessage());
        }
    }
}
*/