package user;

import java.util.HashSet;
import java.util.Set;

public class Users {
    private String username;

    private static Set<String> registeredUsernames = new HashSet<>();

    public Users(String username) {
        this.username = username;
        registeredUsernames.add(username);
    }

    public static boolean isUsernameTaken(String username) {
        return registeredUsernames.contains(username);
    }

    public String getUsername() {
        return username;
    }

    public static boolean usernameExists(String username) {
        return registeredUsernames.contains(username);
    }

    public static Set<String> getRegisteredUsernames() {
        return registeredUsernames;
    }
}

