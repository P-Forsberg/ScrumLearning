package uppgift.user;

import java.util.HashSet;
import java.util.Set;

public class Users {
    private String username;

    private static Set<String> registeredUsernames = new HashSet<>();

    public Users(String username) {
        if (isUsernameTaken(username)) {
            throw new IllegalArgumentException("Username already taken.");
        }
        this.username = username;
        registeredUsernames.add(username);
    }

    public static boolean isUsernameTaken(String username) {
        return registeredUsernames.contains(username);
    }

    public String getUsername() {
        return username;
    }
}
