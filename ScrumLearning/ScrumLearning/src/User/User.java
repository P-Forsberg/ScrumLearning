package User;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String username;

    private static Set<String> registeredUsernames = new HashSet<>();

    public User(String username) {
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
