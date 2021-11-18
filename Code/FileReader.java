import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader implements IO{

    @Override
    public void savePlayerData(ArrayList<Player> players) {
        String playerData = "";
        playerData = "playerName, schoolClass, mail, phoneNumber\n";
           for (Player p : players) {
               playerData += p;
           }

    }

    @Override
    public ArrayList<Player> readPlayerData() {
        ArrayList<Player> players = new ArrayList<>();
        File file = new File("src/playerList.txt");
        Scanner scan = null;

        try {
            scan = new Scanner(file);
            scan.nextLine();
            while(scan.hasNextLine()){
                String [] values = scan.nextLine().split(",");
                int playerID = Integer.parseInt(values[0]);
  //TODO Find ud af om det er den korrekte måde at bruge String
                String playerName = values[1];
                String schoolClass = values[2];
                String mail = values[3];
                String phoneNumber = values[4];
                Player p = new Player(playerID, playerName, schoolClass, mail, phoneNumber);
                players.add(p);

            }

        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch (NoSuchElementException e){
            System.out.println("File is empty");
            
        }

       return players;
    }

    @Override
    public void saveTeamData(ArrayList<Team> teams) {
        String teamData = "";
        teamData = "teamName";
        for (Team t : teams) {
            teamData += t;
        }
    }

    @Override
    public ArrayList<Team> readTeamData() {
        ArrayList<Team> teams = new ArrayList<>();
        File file = new File("src/teamList.txt");
        Scanner scan = null;

        try {
            scan = new Scanner(file);
            scan.nextLine();
            while(scan.hasNextLine()){
                String [] values = scan.nextLine().split(",");
                int teamID = Integer.parseInt(values[0]);
                String teamName = values[1];
                Team team = new Team(teamID, teamName);
                teams.add(team);
            }
        }catch(FileNotFoundException e){
            System.out.println("No file found");
        }catch(NoSuchElementException e){
            System.out.println("File is empty");
        }
        return teams;
    }

    @Override
    public void saveMatchData(ArrayList<Match> matches) {
        String matchData = "";
        matchData = "team1Goals, team2Goals";
           for (Match m : matches) {
               matchData += m;
           }

    }

    @Override
    public ArrayList<Match> readMatchData() {


        return null ;
    }
}
