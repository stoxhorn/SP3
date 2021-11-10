import java.util.Scanner;

public class Match {
    private int matchID;
    private int team1Goals;
    private int team2Goals;

    public void setTeam1Goals(int team1Goals) {
        this.team1Goals = team1Goals;
    }

    public void setTeam2Goals(int team2Goals) {
        this.team2Goals = team2Goals;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMatchDone(boolean matchDone) {
        this.matchDone = matchDone;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    private String date;

    boolean matchDone;

    Team team1;
    Team team2;

    public Match(Team t1, Team t2){
        this.team1 = t1;
        this.team2 = t2;
        this.matchDone = false;
        addDate();
    }

    Scanner input = new Scanner(System.in);

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int newID){
        this.matchID = newID;
    }

    public String getDate() {
        return date;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    private void addDate() {
        System.out.println("Type in the date and time for the match you are adding (format DD/MM/YYYY/TT.TT, for example, 22/10/2000/15.15)");
        date = input.nextLine();
    }

    public Team getWinner(){
            if(team1Goals > team2Goals){
                return team1;
            } else {
                // it is not possible to end a game of table football in a draw
                return team2;
            }
    }

    public void updateResult(int team1Goals, int team2Goals){
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
    }

    public int getTeam1Goals() {
        return team1Goals;
    }

    public int getTeam2Goals() {
        return team2Goals;
    }

    public boolean isMatchDone(){
        return matchDone;
    }

    @Override
    public String toString(){
        String tmp = "";

        tmp += team1.getTeamName() + " vs " +  team2.getTeamName() + "\n";
        if(matchDone){
            tmp += team1.getTeamName() + " goals: " + team1Goals + "\n";
            tmp += team2.getTeamName() + " goals: " + team2Goals + "\n";
            tmp += "The winner is: " + getWinner().getTeamName();
        }
        else{
            tmp += "Match has not been played yet";
        }

        return tmp;
    }

}

