import java.util.ArrayList;
import java.util.Random;

public class KnockoutPhase extends Tournament{

    // You can now create the first round and create the next ones
    // These functions does not add the matches to the arraylist of matches, and as such does not get an ID.

    ArrayList<Match[]> rounds;

    private int numberOfTeams;

    private int numberOfRounds;

    private String tournamentName;

    public ArrayList<Match[]> getTournamentTree() {
        return tournamentTree;
    }

    private ArrayList<Match[]> tournamentTree;



    public KnockoutPhase(String tournamentName) {
        this.tournamentName = tournamentName;
        rounds = new ArrayList<>();

    }



    // Checks last Array of matches, and only does something if all matches are over.
    public void createNextRound(){
        Match[] lastRound = this.rounds.get(-1);

        boolean roundOver = this.isRoundOver(lastRound);

        // if round is not over, return
        if(!roundOver){
            return;
        }
        ArrayList<Team> winners = new ArrayList<>();
        for(Match m : lastRound){
            winners.add(m.getWinner());
        }
        // Create Matches for the next round of winners
        Match[] nextRound = this.makeMatches(winners);
        addRoundToTournament(nextRound);
    }

    private void addRoundToTournament(Match[] matches){
        for(Match m : matches){
            super.addMatch(m);
        }
        this.rounds.add(matches);
    }

    /*
     * If there is a single match that is not done, returns false
     * if all matches in array is over, returns true
     * */
    public boolean isRoundOver(Match[] matches){

        boolean checker = true;
        // If a match is not done, checker will exit loop as false
        for(Match m : matches){
            if(checker == false){
                break;
            }else{
                checker = m.isMatchDone();
            }
        }
        return checker;
    }

    // We can't make the rounds after, only the first round of knockoutmatches
    public void createFirstRound() {
        // TODO: handle what to do if not 16 teams, if this should even be the case
        // Technically this works with any even amount of teams, i'm just lazy
        if (super.getTeams().size() == 16) {
            // Get the matches for next round
            Match[] newRound = makeMatches(super.getTeams());
            this.rounds.add(newRound);
        } else {
            System.out.println("This only works with 16 teams total, no more, no less\n");
        }
    }

    // helper functions for makeBrackets
    // Creates an array of randomized matches, based on an arraylist of teams
    public Match[] makeMatches(ArrayList<Team> teams){
        ArrayList<Team> tmpList = teams;
        Random r = new Random();

        Match[] matches = new Match[tmpList.size()/2];
        // Using teams as i want the original length as cutoff.
        // And not one that changes with each loop
        for(int i = 0; i < (teams.size()/2); i++){
            // get random number in range of teams left
            int rng = r.nextInt(tmpList.size());
            // get the result, and delete from original list
            Team team1 = tmpList.get(rng);
            tmpList.remove(rng);

            rng = r.nextInt(tmpList.size());
            Team team2 = tmpList.get(rng);
            tmpList.remove(rng);

            Match newMatch = new Match(team1, team2);

            matches[i] = newMatch;
        }
        return matches;
    }


    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}
