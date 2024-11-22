package main.java.uppgift;

import main.java.uppgift.menu.Menu;

public class Application {
    private boolean running;
    public static void main(String[] args) {
        System.out.Println("Application");
        Menu menu = new Menu();
        menu.displayMenu();

    }
}