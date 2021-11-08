
import java.util.ArrayList;

public class Team {

    private static int teamIdGenerator = 0;

    private final int teamID;

    private String teamName;

    // UML diagram says this should be static, that is wrong
    ArrayList<Player> players;

 //   private int points;
 //    private int gamesPlayed;
    private int goalsScored;
    private int goalsConceded;

    public Team(int teamID, String teamName) {

        this.teamID = teamID;
        this.teamName = teamName;
        this.players = new ArrayList();
    }

  /*  public int getPoints() {
        return points;
    }*/

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

   /* public int getGamesPlayed() {
        return gamesPlayed;
    }*/

    // Ny funktion af Mads, var ikke i UML diagram
    public void addPlayer(Player newPlayer) {
        players.add(newPlayer);
    }

    public void removePlayer(int playerID) {
        int i = 0;
        for (Player p : this.players) {
            if (p.getPlayerID() == playerID) {
                players.remove(i);
            }
            i += 1;
        }

    }

    @Override
    public String toString(){
        String tmp = "";
        tmp += "TeamID: " + teamID;
        tmp += "\nTeam Name: " + teamName;

        return tmp;
    }
}

