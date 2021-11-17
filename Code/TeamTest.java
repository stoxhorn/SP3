import java.util.ArrayList;

public class TeamTest{
    static ArrayList<Player> players = new ArrayList<>();
    static ArrayList<Team> teams = new ArrayList<>();

    enum Datasource {
        CSVFILE
    }
    private static Datasource datapath;

    public static void main(String[] args){
       TournamentOrganizer organizer = new TournamentOrganizer();
       organizer.showMenu();

        IO io;

        io = new DBConnector();
        Player thobias = new Player("Thobias", "2.a", "thobias@gmail.dk", "40401212"  );
        players.add(thobias);
      //  players = io.readPlayerData();
        ArrayList<Player> playerdata;
        io.savePlayerData(players);
        playerdata = io.readPlayerData();
        System.out.println(playerdata);

        Team thobiashold = new Team(3, "Thobias' hold");
        teams.add(thobiashold);


        ArrayList<Team> teamdata;
        io.saveTeamData(teams);

        teamdata = io.readTeamData();
        System.out.println(teamdata);


    }
}
