import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TournamentOrganizer {

    private Scanner input;

    private String password;
    private String userInput;
    private String tournamentName;

    private KnockoutPhase knockTourny;

    ArrayList<Player> playerList = new ArrayList<Player>();
    ArrayList<Team> teamList = new ArrayList<Team>();

    // todo : Lav en option for både user og organizer for at se den nødvendige information om spillere og evt hold.
    // todo : Kunne være sejt at se de tilmeldte spillere til de forskellige
    // todo : Når man opretter et hold og rerunner koden er holdet gemt i filen, men ikke gemt i listen.
    // todo : Når man opretter spillere og rerunner koden er spillerne gemt i filen og ikke gemt i listen.
    // todo : når man skal add player til team er der ingen back knap når man kommer ind i den menu.
    // todo : flere ting tilføjes her:

    public TournamentOrganizer() {
        input = new Scanner(System.in);
        password = "password";

    }

    public void showMenu() {
        System.out.println("Welcome to the main menu");
        System.out.println("\tPress 1 to enter as a user");
        System.out.println("\tPress 2 to login as the organizer");


        // this needs a try/catch clause
        // For the sake of easy development, could contain the 2 lines below, and just save the return
        String input = this.input.nextLine();
        int inputInt = Integer.parseInt(input);


        if (inputInt == 1) {
            User user = new User();
            user.userMenu();

        } else if (inputInt == 2) {
            organizerLogin();
        } else {
            System.out.println("That is not an option, try again");
            return;
        }
    }

    private void organizerLogin() {

        //todo : få implementeret ignoreCase til back.

        System.out.println("Please enter the Organizer password. \nIf you would like to return to the previous screen, type b");
        boolean running = true;
        while (running) {


            String input = this.input.nextLine();
            String switcher = input;
            try {
                switcher = String.valueOf(Integer.parseInt(input));
            } catch (Exception e) {


            }
            switch (switcher) {
                case "password":
                    organizerMenu();
                    break;
                case "b":
                    showMenu();
                    break;
                default:
                    System.out.println("Wrong password. Please try again or type back to go back to main menu.");
            }

        /*if (input == password) {
            organizerMenu();
        } else if (input == "back") {
            showMenu();
        } else {
            System.out.println("That is not the correct password, please try again");
            return;
        }*/
        }
    }

    private void organizerMenu() {

        System.out.println("Welcome to the Organizer Menu. What would you like to do?");
        System.out.println("\tType 1 to access tournament menu");
        System.out.println("\tType 2 to access team menu");
        System.out.println("\tType 3 to access player menu");
        System.out.println("\tType 4 to access match menu");
        System.out.println("\tType 5 to see the match programme");
        System.out.println("\tType 6 to go back to main menu");
        System.out.println("\tType 7 if the teams has been created and the tournament is ready to be played");
        System.out.println("\tType 8 to save and quit");


        boolean running = true;
        while (running) {

            String input = this.input.nextLine();
            String switcher = input;
            try {
                switcher = String.valueOf(Integer.parseInt(input));
            } catch (Exception e) {

            }
            switch (switcher) {
                case "1":
                    tournamentMenu();
                    break;
                case "2":
                    teamMenu();
                    break;
                case "3":
                    playerMenu();
                    break;
                case "4":
                    matchMenu();
                    break;
                case "5":
                    viewMatchProgramme();
                    break;
                case "6":
                    showMenu();
                    break;
                case "7":
                    finalizeTournament();
                    break;
                case "8":
                    save();
                    running = false;
                default:
                    System.out.println("That is not an option, try again");

            }
            /*String input = this.input.nextLine();

            if (input == "1") {
                tournamentMenu();
            } else if (input == "2") {
                teamMenu();
            } else if (input == "3") {
                playerMenu();
            } else if (input == "4") {
                matchMenu();
            } else if (input == "5") {
                viewMatchProgramme();
            } else if (input == "6") {
                showMenu();
            } else if (input == "7") {

            } else if (input == "8") {
                save();
                running = false;
            } else {
                System.out.println("That is not an option, try again");
                return;
            }*/
        }

        // viewTeams(); //hmmm hvor skal den være?

    }

    private void tournamentMenu() {
        System.out.println("Welcome to the tournament menu");

        System.out.println("\tType 1 to create a new tournament");
        System.out.println("\tType 2 to edit an existing tournament");
        System.out.println("\tType 3 to delete existing tournament");
        System.out.println("\tType 4 to change the tournament rules");
        System.out.println("\tType 5 to view the tournament rules");
        System.out.println("\tType 6 to go back to organizer menu");

        boolean running = true;
        while (running) {
            String input = this.input.nextLine();
            String switcher = input;

            try {
                switcher = String.valueOf(Integer.parseInt(input));
            } catch (Exception e) {

            }
            switch (switcher) {
                case "1":
                    createNewTournament();
                    break;
                case "2":
                    editTournament();
                    break;
                case "3":
                    deleteTournament();
                    break;
                case "4":
                    setTournamentRules();
                    break;
                case "5":
                    viewTournamentRules();
                case "6":
                    organizerMenu();
                default:
                    System.out.println("That is not an option, try again");

            }

        /*if (input == "1") {
            createNewTournament();
        } else if (input == "2") {
            editTournament();
        } else if (input == "3") {
            deleteTournament();
        } else if (input == "4") {
            organizerMenu();
        } else {
            System.out.println("That is not an option, please try again");
            return;
        }*/
        }
    }


    private void teamMenu() {
        System.out.println("Welcome to the team menu");

        System.out.println("\tType 1 to create a new team.");
        System.out.println("\tType 2 to edit team.");
        System.out.println("\tType 3 to delete team.");
        System.out.println("\tType 4 to go back to organizer menu.");

        boolean running = true;
        while (running) {

            String input = this.input.nextLine();
            String switcher = input;

            try {
                switcher = String.valueOf(Integer.parseInt(input));
            } catch (Exception e) {

            }
            switch (switcher) {
                case "1":
                    createTeam();
                    break;
                case "2":
                    editTeam();
                    break;
                case "3":
                    deleteTeam();
                    break;
                case "4":
                    organizerMenu();
                default:
                    System.out.println("That is not an option, try again");

            }


        /*if (input == "1") {
            addTeam();
        } else if (input == "2") {
            editTeam();
        } else if (input == "3") {
            deleteTeam();
        } else if (input == "4") {
            organizerMenu();
        } else {
            System.out.println("That is not an option, please try again");
            return;
        }*/
        }
    }
    private void createPlayer() {

        int ID = 0;

        System.out.println("Enter the name of the player you wish to create");
        String name = input.nextLine();

        System.out.println("Enter the class of which the student attends. An example could be 3.f or \"Biologi class of '02\"");
        String schoolClass = input.nextLine();

        System.out.println("Enter the email address of the player you wish to add. An example could be anEmail@gmail.com");
        String mail = input.nextLine();

        System.out.println("Enter the phone number of the student you wish to add. An example could be +45 1234 5678");
        String phoneNumber = input.nextLine();

        System.out.println("This is the information of the player you are about to create");
        System.out.println("Name: " + name + "\nSchool class: " + schoolClass + "\nEmail: " + mail + "\nPhone number: " + phoneNumber);
        System.out.println("Do you wish to create this player? \nPress \"y\" for yes and \"n\" for no.");
        while (true) {
            String playerSaveResponse = input.nextLine();
            if (playerSaveResponse.equalsIgnoreCase("Y")) {
                Player player1 = new Player(ID, name, schoolClass, mail, phoneNumber);
                playerList.add(player1);
                savePlayerToFile(player1);
                IO io;
                io = new DBConnector();
                io.savePlayerData(playerList);
                System.out.println("The player has been created!");
                break;
            } else if (playerSaveResponse.equalsIgnoreCase("N")) {
                System.out.println("The player was not created");
                break;
            } else {
                System.out.println("This is an invalid input, please either press \"y\" for yes, or \"n\" for no");
            }
        }
        playerMenu();
    }


    private void addPlayerToTeam(){
        System.out.println("This is the player list");

        for (int i = 0; i < playerList.size(); i++) {
            System.out.println(playerList.get(i).getPlayerName() + " - " + playerList.get(i).getSchoolClass());

        }
        System.out.println("Enter the name of the player you wish to move to a team. Type b to go back");

        Player player1 = null;
        boolean foundPlayer = false;
        while(!foundPlayer){
            String name = input.nextLine();
            for (int i = 0; i < playerList.size(); i++) {
                if(playerList.get(i).getPlayerName().equalsIgnoreCase(name)) {
                    player1 = playerList.get(i);
                    foundPlayer = true;
                    break;
                    //Hvis flere spiller har det samme navn går det galt. ID vil nok fikse det.

                }
            }
            if(!foundPlayer){
                System.out.println("There is no player with this name. Please input another name");
            }

        }

        System.out.println("This is the team list");

        for (int i = 0; i < teamList.size(); i++) {
            System.out.println(teamList.get(i).getTeamName());
        }

        System.out.println("Enter the team of which you want the player to join");


        boolean foundTeam = false;
        while(!foundTeam) {
            String teamName = input.nextLine();
            for (int i = 0; i < teamList.size(); i++) {
                if (teamList.get(i).getTeamName().equalsIgnoreCase(teamName)) {
                    teamList.get(i).addPlayer(player1);
                    foundTeam = true;
                    System.out.println("The player, " + player1.getPlayerName() + " was added to the team " + teamName);
                    playerMenu();

                    //Hvis flere spiller har samme navn opstår der problemer, ID vil fikse det.

                }
            }
            if (!foundTeam) {
                System.out.println("There is no team with this name. Please input another team name");
            }
        }

    }

    private void save() { //Denne funktion er muligvis overflødig
    }

    private void createMatch() {
        System.out.println("Please insert the name of the first team here: ");
        boolean running = true;
        while (running) {
            for (Team t : this.knockTourny.getTeams()) {

        }
        /*userInput = input.nextLine();
        Team team1 = null; //
        Team team2 = null;

        Match newMatch = new Match();

        newMatch.setTeam1(team1);
        newMatch.setTeam2(team2);
*/
        }
    }

    private void savePlayerToFile(Player p) {
        String playerData = "";
        playerData = "playerID, playerName, schoolClass, mail, phoneNumber \n";

        playerData += p;

        try {
            FileWriter writer = new FileWriter("src/playerList.txt",true);
            writer.write(playerData);
            writer.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private void savePlayerListToFile() {
        String playerData = "";

        for (Player a : playerList) {
            playerData += a;
        }

        try {
            FileWriter writer = new FileWriter("src/playerList.txt");
            writer.write(playerData);
            writer.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    private void createTeam() {
        int ID = 0;

        System.out.println("Enter the name of the team you wish to create");
        String teamName = input.nextLine();

        System.out.println("This is the name of the team you are about to create");
        System.out.println("Name: " + teamName);
        System.out.println("Do you wish to create this team? \nPress y for yes and n for no.");
        while (true) {
            String playerSaveResponse = input.nextLine();
            if (playerSaveResponse.equalsIgnoreCase("Y")) {
                Team team1 = new Team(ID, teamName);
                teamList.add(team1);
                saveTeamToFile(team1);
                IO io;
                io = new DBConnector();
                io.saveTeamData(teamList);
                System.out.println("The team has been created!");
                break;
            } else if (playerSaveResponse.equalsIgnoreCase("N")) {
                System.out.println("The team was not created");
                break;
            } else {
                System.out.println("This is an invalid input, please either press y for yes, or n for no");
            }
        }
        teamMenu();
    }

    private void finalizeTournament() {
        System.out.println("Are you certain you want to finalize the tournament? \nIf you want to finalize the tournament, type \"Finalize\", if you want to go back, type \"Undo\"");
        String playerSaveResponse = input.nextLine();
        while (true) {
            if (playerSaveResponse.equalsIgnoreCase("Finalize")) {
                for (Team t : teamList) {
                    knockTourny.addTeam(t.getPlayers(), t.getTeamName());
                }
                System.out.println("The tournament has been finalized and is now ready to be played!");
                break;

            } else if (playerSaveResponse.equalsIgnoreCase("Undo")) {
                System.out.println("The tournament finalization was canceled");

            } else {
                System.out.println("This is an invalid input, please either type \"Finalize\" to create the tournament, or \"Undo\" to cancel the creation of the tournament");
            }
        }
        //displayTournament(); to show a visualisation of the bracket (family tree)
    }

    private void editTeam(){
        boolean running = true;
        while (running) {

        }
    }

    private void editTournament() {
        boolean running = true;
        while (running) {

        }
    }

    private void createNewTournament() {
        System.out.println("Please enter the name of your new tournament ");
        boolean running = true;
        while (running) {
                        this.tournamentName = input.nextLine();
            this.knockTourny = new KnockoutPhase(tournamentName);
            System.out.println("Your tournament is now called: " + tournamentName + "\n");
            System.out.println("Would you like to add a new team to the tournament?");
            String input = this.input.nextLine();

        }
    }

    private void deleteTeam(){
        System.out.println("Please enter the name of the team you want to remove from the tournament: ");
        boolean running = true;
        while (running) {

        }

    }

    private void setTournamentRules() {
        System.out.println("By default we have the following rules for knockout phase: ");
        System.out.println("The game is won when a team reaches 10 goals. The winner will advance to the next stage while the loser is out");
        System.out.println("When a team concedes a goal, they will be responsible for re-starting the game");
        System.out.println("While playing you are not allowed to spin your players \n");
        System.out.println("\tType 1 to add a new rule for the tournament");
        System.out.println("\tType 2 to view the tournament rules");
        System.out.println("\tType 3 to go back to organizer menu");
        boolean running = true;
        while (running) {
            String input = this.input.nextLine();
            String switcher = input;

            try {
                switcher = String.valueOf(Integer.parseInt(input));
            } catch (Exception e) {

            }
            switch (switcher) {
                case "1":
                    addRules();
                    break;
                case "2":
                    viewTournamentRules();
                    break;
                case "3":
                    organizerMenu();
                default:
                    System.out.println("That is not an option, try again");

            }

            /*if (input == "1") {
                addRules();
            } else if (input == "2") {
                organizerMenu();
            } else {
                System.out.println("That is not a valid answer. Please try again");
            }*/

        }
    }

    private void saveTeamToFile (Team t) {
        String teamData = "";

        teamData += t;

        try {
            FileWriter writer = new FileWriter("src/teamList.txt",true);
            writer.write(teamData);
            writer.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void addRules() {
        // Skal kodes så vi kan tilføje regler til tournamentrules.txt

        System.out.println("Please enter a new rule to add to the tournament rule: ");
        boolean running = true;
        while (running) {
            try {
                String filePath = "src/tournamentrules.txt";
                FileWriter fw = new FileWriter(filePath, true);

                String lineToAppend = input.nextLine();
                fw.write(lineToAppend + "\n");
                fw.close();
                running = false;
                System.out.println("Thank you for adding a new rule.");
                System.out.println("\tType 1 to add a new tournament rules");
                System.out.println("\tType 2 to view tournament rules");
                System.out.println("\tType 3 to go back to organizer menu");


            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void viewMatchProgramme() {
        //Kalender med datoer, hold og kampe
        System.out.println("The upcoming matches are as follows: ");
        boolean running = true;
        while (running) {

        }
    }

    private void viewTournamentRules() {
        // Made by Frederik-Hans og jeg blev lidt tabt i koden  );
        boolean running = true;
        while (running) {
            File rules = new File("src/tournamentrules.txt");
            Scanner input = null;
            try {
                input = new Scanner(rules);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
            running = false;
        }
        System.out.println("__________________________");
        System.out.println("Type 1 to add a new tournament rules");
        System.out.println("Type 2 to view tournament rules");
        System.out.println("Type 3 to go back to organizer menu");
    }



    private void viewTeams() {
        boolean running = true;
        while (running) {

        }
    }

    private void deleteTournament() {
        boolean running = true;
        while (running) {

        }
    }
    private void deleteMatch() {
        System.out.println("Select the match you wish to delete");
        boolean running = true;
        while (running) {

        }
    }

    private void editMatch() {
        System.out.println("Select the match you with to edit");
        boolean running = true;
        while (running) {

        }
    }


    private void deletePlayer() {
        System.out.println("Select the player you wish to delete");
        boolean running = true;
        while (running) {

        }
    }

    private void editPlayer() {
        boolean running = true;
        while (running) {

        }
    }

    private void matchMenu() {
        System.out.println("Welcome to the match menu");
        System.out.println("\tType 1 to create a new match");
        System.out.println("\tType 2 to edit an existing match");
        System.out.println("\tType 3 to delete a match");
        System.out.println("\tType 4 to go back to organizer menu");
        boolean running = true;
        while (running) {
            String input = this.input.nextLine();
            String switcher = input;

            try {
                switcher = String.valueOf(Integer.parseInt(input));
            } catch (Exception e) {

            }
            switch (switcher) {
                case "1":
                    createMatch();
                    break;
                case "2":
                    editMatch();
                    break;
                case "3":
                    deleteMatch();
                    break;
                case "4":
                    organizerMenu();
                default:
                    System.out.println("That is not an option, try again");

            }
        /*if (input == "1") {
            createMatch();
        } else if (input =="2") {
            editMatch();
        } else if (input == "3") {
            deleteMatch();
        } else if (input == "4") {
            organizerMenu();
        } else {
            System.out.println("That is not an option, please try again");
            return;
        }*/
        }
    }
private void playerMenu() {
    System.out.println("Welcome to the player menu");
    System.out.println("\tType 1 to add a new player");
    System.out.println("\tType 2 to add a player to a team");
    System.out.println("\tType 3 to delete a player");
    System.out.println("\tType 4 to edit a player");
    System.out.println("\tType 5 to go back to the organizer menu");

    boolean running = true;
    while (running) {
        String input = this.input.nextLine();
        String switcher = input;

        try {
            switcher = String.valueOf(Integer.parseInt(input));
        } catch (Exception e) {

        }
        switch (switcher) {
            case "1":
                createPlayer();
                break;
            case "2":
                addPlayerToTeam();
                break;
            case "3":
                deletePlayer();
                break;
            case "4":
                editPlayer();
                break;
            case "5":
                organizerMenu();
            default:
                System.out.println("That is not an option, try again");
        }

    /*if (input == "1") {
        addPlayer();
    } else if (input == "2") {
        addPlayerToTeam();
    } else if (input == "3") {
        deletePlayer();
    } else if (input == "4") {
        editPlayer();
    } else if (input == "5") {
        organizerMenu();
    } else {
        System.out.println("That is not an option, please try again");
        return;
    }*/
    }
    }
}
