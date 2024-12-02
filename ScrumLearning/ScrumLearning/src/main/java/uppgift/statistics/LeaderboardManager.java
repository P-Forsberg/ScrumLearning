package uppgift.statistics;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LeaderboardManager {
    private List<Player> playerStats;
    private static final String FILE_PATH = "players.json";

    public LeaderboardManager() {
        this.playerStats = new ArrayList<>();
        loadPlayers();
    }

    private void loadPlayers() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            playerStats = objectMapper.readValue(new File(FILE_PATH),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));
        } catch (IOException e) {
            System.out.println("Error loading players from JSON: " + e.getMessage());
        }
    }

    public void addPlayer(Player player) {
        if (!playerStats.contains(player)) {
            playerStats.add(player);
        }
    }

    public void displayLeaderboard() {
        System.out.println("=== Total Leaderboard ===");
        Collections.sort(playerStats, (p1, p2) -> Integer.compare(
                p2.getStatisticManager().getScore(), p1.getStatisticManager().getScore()));
        for (Player player : playerStats) {
            System.out.printf("%s: %d points\n", player.getUsername(), player.getStatisticManager().getScore());
        }
    }

    public void displayPlayerStats(String playerName) {
        for (Player player : playerStats) {
            if (player.getUsername().equals(playerName)) {
                System.out.printf("=== Stats for %s ===\n", playerName);
                player.displayStatistics();
                return;
            }
        }
        System.out.println("Player not found.");
    }
}
