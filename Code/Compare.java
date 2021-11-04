import java.util.Comparator;

public class Compare implements Comparator {


    @Override  //implementerer metoderne for Comparator-klassen
    public int compare(Team team1, Team team2) {
        int goalDifference = goalsScored - goalsConceded;

        if (team1.getPoints() > team2.getPoints() ) {
            return 1;
        } else if (team1.goalDifference > team2.goalDifference) {
            return 1;
        } else if (team1.getGoalsScored() > team2.getGoalsScored() ) {
            return 1;
        } else {
            return 2;
        }

    }
}
