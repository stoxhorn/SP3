import java.util.ArrayList;

public interface IO {
    void savePlayerData(ArrayList<Player> players);
    ArrayList<Player> readPlayerData();

    void saveTeamData(ArrayList<Team> teams);
    ArrayList<Team> readTeamData();

    void saveMatchData (ArrayList<Match> matches);
    ArrayList<Match> readMatchData();
}
