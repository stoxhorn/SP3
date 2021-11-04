package Code;

import java.util.ArrayList;

public class Team {

    private final int teamID;
    private String teamName;
    int points;
    int gamesPlayed;
    int goalsScored;
    int goalsConceded;

    ArrayList<Integer> playerIDs = new ArrayList<Integer>();
    ArrayList<Integer> matchIDs = new ArrayList<Integer>();

    public Team(int teamID, String teamName) {
        this.teamID = teamID;
        this.teamName = teamName;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }
}

