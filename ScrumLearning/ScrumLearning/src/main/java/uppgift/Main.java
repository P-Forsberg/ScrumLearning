package main.java.uppgift;

import User.UserManager;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.registerUser();
        userManager.close();
    }
}
