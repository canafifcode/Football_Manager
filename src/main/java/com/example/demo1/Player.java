package com.example.demo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.max;

public class Player {
    private String name;
    private String position;
    private String league;
    private String team;
    private Map<String, Integer> stats;
    private int overall;

    public Player(String name, String position, String league, String team, Map<String, Integer> stats, int overall) {
        this.name = name;
        this.position = position;
        this.league = league;
        this.team = team;
        this.stats = stats;
        this.overall = overall;
    }

    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public String getLeague() {
        return league;
    }
    public String getTeam() {
        return team;
    }
    public int getOverall() {
        return overall;
    }
    public Map<String, Integer> getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return name + " (" + position + ")";
    }

    public List<Player> loadPlayersForTeam(String teamName) {
        List<Player> players = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("players.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String league= parts[0].trim();
                    String team = parts[1].trim();
                    String playerName = parts[2].trim();
                    String position = parts[3].trim();
                    int overall=Integer.parseInt(parts[4].trim());
                    Map<String, Integer> stats= new HashMap<>();

                    if (team.equalsIgnoreCase(teamName)){
                        if (position.equalsIgnoreCase("GK")){
                            for (int i=5; i<Math.min(parts.length,10);i++){
                                String[] statspart=parts[i].split(";");
                                if(statspart.length==2){
                                    stats.put(statspart[0].trim(), Integer.parseInt(statspart[1].trim()));
                                }
                            }
                        }
                        else{
                            for (int i = 5; i < Math.min(parts.length, 11); i++) {
                                String[] statParts = parts[i].split(":");
                                if (statParts.length == 2) {
                                    stats.put(statParts[0].trim(), Integer.parseInt(statParts[1].trim()));
                                }
                            }
                        }
                        players.add(new Player(playerName, position, league, team, stats, overall));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading");
            e.printStackTrace();
        }
        return players;
    }

}
