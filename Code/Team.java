
import java.util.ArrayList;

public class Team {

    private static int teamIdGenerator = 0;

    private final int teamID;

    private String teamName;

    ArrayList<Player> players;

 // private int points;
 // private int gamesPlayed;
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
    public int getID(){
      return this.teamID;
    }

    public int getAmountOfPlayers(){
        return this.players.size();
    }

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

    public void addGoalsScored(int goals){
        this.goalsScored += goals;
    }

    public void addGoalsConceded(int goals){
        this.goalsConceded += goals;
    }

    @Override
    public String toString(){
        String tmp = "";
        tmp += "\n" + "Team ID: " + teamID + ", " + "Team name: " + teamName + "\nGoals Scored: " + goalsScored + " Goals Conceded: " + goalsConceded;
        for(Player p : this.players){
            tmp += "\n" + p;
        }
        return tmp;
    }


    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public String getTeamName(){
        return this.teamName;
    }
}

