
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Tournament {
    public ArrayList<Match> getMatches() {
        return matches;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    private ArrayList<Match> matches;
    private ArrayList<Team> teams;
    private ArrayList<Player> playerList;

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public Tournament(){
        this.matches = new ArrayList<>();
        this.teams = new ArrayList<>();

    }

    // overloaded to take ArrayList
    public void addTeam(ArrayList<Player> players, String teamName){
        Player[] tmp = new Player[players.size()];
        int i = 0;
        for (Player p : players){
            tmp[i] = p;
            i += 1;
        }
        addTeamHelper(tmp, teamName);
    }

    // Overloaded to take Array
    public void addTeam(Player[] players, String teamName){
        addTeamHelper(players, teamName);
    }

    private void addTeamHelper(Player[] players, String teamName){
        // If there is already 16 teams, print message and do nothing
        if(this.teams.size() >= 16){
            System.out.println("There is already 16 teams, cannot add more");
            return;
        }

        int teamID = this.teams.size();

        Team newTeam = new Team(teamID, teamName);

        int i = 0;
        for(Player p : players){
            Player newPlayerObject = p.copyPlayer(this.getAmountOfPlayers() + i);
            newTeam.addPlayer(newPlayerObject);
            i += 1;
        }

        this.teams.add(newTeam);
    }

    public int getAmountOfPlayers(){
        int i = 0;
        for(Team t: this.teams){
            i += t.getAmountOfPlayers();
        }
        return i;
    }


    // this isn't planned to use, as we want to make it easier for ourselves when using knockoutphase
    public void addMatch(Match newMatch){
        newMatch.setMatchID(this.matches.size());
        this.matches.add(newMatch);
    }

    // this isn't planned to use, as we want to make it easier for ourselves when using knockoutphase
    public void removeMatch(){

    }

    public void editMatch(int matchId, int team1Goals, int team2Goals){
        this.matches.get(matchId).updateResult(team1Goals, team2Goals);
    }


    public void getWinner(){

    }

    // Lavet af Frederik - ingen garanti for noget som helst er rigtigt
    // pt. gemmer den kun team arraylist data - den skal også gemme matches og players.
    public void saveToFile(){
        String tournamentData = "";

        for(Team e: teams){
            tournamentData += e;
        }

        try {
            FileWriter writer = new FileWriter("src/data.txt"); // Skal muligvis ikke have src foran
            writer.write(tournamentData);
            writer.close();
            System.out.println("Successfully added data to file");
        }catch (IOException e){
            System.out.println("An error occurred");
            e.getStackTrace();
        }
    }

    @Override
    public String toString(){
        String tmp = "Teams, players and matches of the tournament:\n\n";

        // for every team
        for(Team t : this.teams){
            // get all their matches
            ArrayList<Match> teamsMatches = new ArrayList<>();
            for(Match m : this.matches){
                if(m.getTeam1().getID() == t.getID()){
                    teamsMatches.add(m);
                }else if(m.getTeam2().getID() == t.getID()){
                    teamsMatches.add(m);
                }else{
                    // pass
                }
            }
            // gather data into one string
            String loopTmp = "";

            loopTmp += t.toString();
            loopTmp += "\nPlayers:\n";
            for(Player p : t.getPlayers()){
                loopTmp += "\n" + p.toString();
            }

            loopTmp += "\nMatches:\n";

            for(Match m : teamsMatches){
                loopTmp += m.toString();
            }

            tmp += loopTmp + "\n ---- \n";

        }

        return tmp;
    }

}
