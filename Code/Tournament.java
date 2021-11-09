
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

    public Tournament(){
        this.matches = new ArrayList<>();
        this.teams = new ArrayList<>();

    }

    public void addTeam(){

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
}
