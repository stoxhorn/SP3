import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TournamentOrganizer {
    private Scanner input;
    private String password;
    private String userInput;
    private String tournamentName;

    public TournamentOrganizer() {
        input = new Scanner(System.in);
        password = "password";

    }
    public void showMenu() {
        System.out.println("Welcome to the main menu");
        System.out.println("Press 1 to enter as a user");
        System.out.println("Press 2 to login as the organizer");


        // this needs a try/catch clause
        // For the sake of easy development, could contain the 2 lines below, and just save the return
        String input = this.input.nextLine();
        int inputInt = Integer.parseInt(input);

        if (inputInt == 1) {
         //   userMenu();
        }
        else if (inputInt == 2) {
            organizerLogin();
        }
        else {
            System.out.println("That is not an option, try again");
            return;
        }
    }

    private void organizerLogin() {
        System.out.println("Please enter the Organizer password. \nIf you would like to return to the previous screen, type back.");

        String input = this.input.nextLine();
        String switcher = input;
        try {
            switcher = String.valueOf(Integer.parseInt(input));
        } catch (Exception e) {

        }
        switch (switcher) {
            case "password": organizerMenu();
                break;
            case "back" : showMenu();
                break;
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
    private void organizerMenu() {

        System.out.println("Welcome to the Organizer Menu. What would you like to do? ;(");
        System.out.println("Type 1 to access tournament menu");
        System.out.println("Type 2 to access team menu");
        System.out.println("Type 3 to access player menu");
        System.out.println("Type 4 to access match menu");
        System.out.println("Type 5 to see the match programme");
        System.out.println("Type 6 to go back to main menu");
        System.out.println("Type 7 to save and quit");

        boolean running = true;
        while (running) {

            String input = this.input.nextLine();
            String switcher = input;
            try {
                switcher = String.valueOf(Integer.parseInt(input));
            } catch (Exception e) {

            }
            switch (switcher) {
                case "1": tournamentMenu();
                    break;
                case "2": teamMenu();
                    break;
                case "3" : playerMenu();
                    break;
                case "4" : matchMenu();
                    break;
                case "5" : viewMatchProgramme();
                    break;
                case "6" : showMenu();
                    break;
                case "7" : save();
                           running = false;
                default: System.out.println("That is not an option, try again");

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

        viewTeams(); //hmmm hvor skal den være?

    }
    private void tournamentMenu() {
        System.out.println("Welcome to the tournament menu");

        System.out.println("Type 1 to create a new tournament");
        System.out.println("Type 2 to edit an existing tournament");
        System.out.println("Type 3 to delete existing tournament");
        System.out.println("Type 4 to go back to organizer menu");

        String input = this.input.nextLine();
        String switcher = input;

        try {
            switcher = String.valueOf(Integer.parseInt(input));
        } catch (Exception e) {

        }
        switch (switcher) {
            case "1" : createNewTournament();
        break;
            case "2" : editTournament();
        break;
            case "3" : deleteTournament();
        break;
            case "4" : organizerMenu();
        default: System.out.println("That is not an option, try again");

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
    private void teamMenu(){
        System.out.println("Welcome to the team menu");

        System.out.println("Type 1 to add a new team to tournament");
        System.out.println("Type 2 to edit team");
        System.out.println("Type 3 to delete team");
        System.out.println("Type 4 to go back to organizer menu");

        String input = this.input.nextLine();
        String switcher = input;

        try {
            switcher = String.valueOf(Integer.parseInt(input));
        } catch (Exception e) {

        }
        switch (switcher) {
            case "1" : addTeam();
                break;
            case "2" : editTeam();
                break;
            case "3" : deleteTeam();
                break;
            case "4" : organizerMenu();
            default: System.out.println("That is not an option, try again");

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
    private void addPlayer() {
    }

    private void addPlayerToTeam(){


    }
    private void save() { //Denne er muligvis overflødig
    }

    private void createMatch() {

        System.out.println("Please insert the name of the first team here: ");


    }


    private void addTeam() {
            System.out.println("Please insert the name of the new team");
            String fromInput = input.nextLine();

    }

    private void editTeam(){

    }

    private void editTournament() {
    }

    private void createNewTournament() {
        System.out.println("Please enter the name of your new tournament ");

        this.tournamentName = input.nextLine();
        KnockoutPhase knockoutPhase = new KnockoutPhase(tournamentName);
        setTournamentRules();
    }

    private void deleteTeam(){
        System.out.println("Please enter the name of the team you want to remove from the tournament: ");


    }

    private void setTournamentRules() {
        System.out.println("By default we have the following rules for knockout phase: ");
        System.out.println("The game is won when a team reaches 10 goals. The winner will advance to the next stage while the loser is out");
        System.out.println("When a team concedes a goal, they will be responsible for re-starting the game");
        System.out.println("While playing you are not allowed to spin your players");
        System.out.println("Type 1 to add a new tournament rules");
        System.out.println("Type 2 to go back to organizer menu");

        String input = this.input.nextLine();

        if(input == "1") {
            addRules();
        } else if(input == "2") {
            organizerMenu();
        } else {
            System.out.println("That is not a valid answer. Please try again");
        }


    }

    private void addRules() {
        // Skal kodes så vi kan tilføje regler til tournamentrules.txt
        // lavet af Frederik og indeholder helt sikkert ikke fejl

        System.out.println("Please enter a new rule to add to the tournament rules: ");
        try
        {
            String filePath = "src/tournamentrules.txt";
            FileWriter fw = new FileWriter(filePath, true);

            String lineToAppend = input.nextLine();
            fw.write(lineToAppend);
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private void viewMatchProgramme() {
        //Kalender med datoer, hold og kampe
        System.out.println("The upcoming matches are as follows: ");

    }

    private void viewTournamentRules(){
    // Made by Frederik-Mark og jeg blev lidt tabt i koden  );
        File rules = new File("src/tournamentrules.txt");
        Scanner input = null;
        try {
            input = new Scanner(rules);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }

    }


    private void viewTeams() {

    }

    private void deleteTournament() {

    }
    private void deleteMatch() {
        System.out.println("Select the match you wish to delete");

    }

    private void editMatch() {
        System.out.println("Select the match you with to edit");
    }

    private void deletePlayer() {
        System.out.println("Select the player you wish to delete");

    }

    private void editPlayer() {

    }

    private void matchMenu() {
        System.out.println("Welcome to the match menu");
        System.out.println("Type 1 to create a new match");
        System.out.println("Type 2 to edit an existing match");
        System.out.println("Type 3 to delete a match");
        System.out.println("Type 4 to go back to organizer menu");

        String input = this.input.nextLine();
        String switcher = input;

        try {
            switcher = String.valueOf(Integer.parseInt(input));
        } catch (Exception e) {

        }
        switch (switcher) {
            case "1" : createMatch();
                break;
            case "2" : editMatch();
                break;
            case "3" : deleteMatch();
                break;
            case "4" : organizerMenu();
            default: System.out.println("That is not an option, try again");

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

private void playerMenu() {
    System.out.println("Welcome to the player menu");
    System.out.println("Type 1 to add a new player");
    System.out.println("Type 2 to add a player to a team");
    System.out.println("Type 3 to delete a player");
    System.out.println("Type 4 to edit a player");
    System.out.println("Type 5 to go back to the organizer menu");

    String input = this.input.nextLine();
    String switcher = input;

    try {
        switcher = String.valueOf(Integer.parseInt(input));
    } catch (Exception e) {

    }
    switch (switcher) {
        case "1" : addPlayer();
            break;
        case "2" : addPlayerToTeam();
            break;
        case "3" : deletePlayer();
            break;
        case "4" : editPlayer();
            break;
        case "5" : organizerMenu();
        default: System.out.println("That is not an option, try again");
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
