import java.sql.*;
import java.util.ArrayList;

public class DBConnector implements IO {

    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/Bordfodbold";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "MbhAoFde9o2_Ded11i112021";


    public ArrayList<Player> readPlayerData() {
        ArrayList<Player> playerData = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
           // Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();


            String sql = "SELECT * FROM Player";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int playerID  = rs.getInt("playerID");
                String playerName = rs.getString("playerName");
                String schoolClass = rs.getString("SchoolClass");
                String mail = rs.getString("mail");
                String phoneNumber = rs.getString("phoneNumber");
                playerData.add(new Player(playerID, playerName, schoolClass, mail, phoneNumber));

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

            return playerData;
    }

    @Override
    public void savePlayerData(ArrayList<Player> players) {
        Connection conn = null;
        Statement stmt = null;

        String sql = "INSERT INTO Player (playerName, schoolClass, mail, phoneNumber)" +
                "VALUES (?, ?, ?, ?)";
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for (Player p : players) {
                //pstmt.setInt(1, p.getPlayerID());
                pstmt.setString(1, p.getPlayerName());
                pstmt.setString(2, p.getSchoolClass());
                pstmt.setString(3, p.getMail());
                pstmt.setString(4, p.getPhoneNumber());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    //TODO
    @Override
    public void saveTeamData(ArrayList<Team> teams) {
        Connection conn = null;
        Statement stmt = null;

        String sql = "INSERT INTO Team (teamName, players, goalsScored, goalsConceded)" +
                "VALUES (?, ?, ?, ?)";
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for (Team t : teams) {
                ArrayList<Player> tmpList = t.getPlayers();
                String tmpStr = "";
                for(Player p : tmpList){
                    tmpStr += p.getPlayerID() + ",";
                }
                
                pstmt.setString(1, t.getTeamName());
                pstmt.setString(2, tmpStr);
                pstmt.setInt(3, t.getGoalsScored());
                pstmt.setInt(4, t.getGoalsConceded());
                System.out.println(pstmt);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    
    }

    @Override
    public ArrayList<Team> readTeamData() {
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<String> teamData = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            // Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();


            String sql = "SELECT * FROM Team";
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<Player> playerList = readPlayerData();

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int teamID  = rs.getInt("teamID");
                String teamName = rs.getString("teamName");

                int goalsScored = Integer.parseInt(rs.getString("goalsScored"));
                int goalsConceded = Integer.parseInt(rs.getString("goalsConceded"));

                String[] playerString = rs.getString("players").split(",");


                Team newTeam = new Team(teamID, teamName);

                newTeam.addGoalsConceded(goalsScored);
                newTeam.addGoalsConceded(goalsConceded);

                if(playerString.length != 0) {
                    for (String i : playerString) {
                        newTeam.addPlayer(playerList.get(Integer.parseInt(i)-1));
                    }
                }
                teams.add(newTeam);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try


        return teams;
    }

    @Override
    public void saveMatchData(ArrayList<Match> matches) {

    }

    @Override
    public ArrayList<Match> readMatchData() {
        ArrayList<Match> matchData = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            // Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();


            String sql = "SELECT * FROM Match";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int matchID  = rs.getInt("ID");

                matchData.get(Integer.parseInt(matchID + "," + "team1Goals" + " :"));

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        return matchData;
    }
}