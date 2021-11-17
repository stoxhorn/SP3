import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private Scanner input = new Scanner(System.in);


    protected void userMenu() {
        System.out.println("Welcome to the user menu. What would you like to do?");
        System.out.println("\tType 1 to view the match programme");
        System.out.println("\tType 2 to view the teams participating in the tournament");
        System.out.println("\tType 3 to view the tournament rules");
        System.out.println("\tType 4 to go back to main menu");

        boolean running = true;
        while (running) {

            String input = this.input.nextLine();
            String switcher = input;
            try {
                switcher = String.valueOf(Integer.parseInt(input));
            } catch (Exception e) {

            }
            switch (switcher) {
                case "1": viewMatchProgramme();
                    break;
                case "2": viewTeams();
                    break;
                case "3": viewTournamentRules();
                    break;
                case "4":
                    TournamentOrganizer to = new TournamentOrganizer();
                    to.showMenu();
                    break;

                default:
                    System.out.println("That is not an option, try again");
            }
          /*  if (userInput == "1") {
                viewMatchProgramme();
            } else if (userInput == "2") {
                viewTeams();
            } else if (userInput == "3") {
                viewTournamentRules();
            } else if (userInput == "4") {
                // showMenu();
            } else {
                System.out.println("That is not an option, try again");
                return;
            }*/
        }
    }

    
    private void viewTeams() {
        IO io;

        io = new DBConnector();
        io.readTeamData();

        ArrayList<Team> teamdata;
        teamdata = io.readTeamData();
        System.out.println(teamdata);
    }

    private void viewMatchProgramme() {
      //  return matchProgramme;
    }

    private void viewTournamentRules() {
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
            System.out.println("___________________________");
            System.out.println("Type 1 to view the match programme");
            System.out.println("Type 2 to view the teams participating in the tournament");
            System.out.println("Type 3 to view the tournament rules");
            System.out.println("Type 4 to go back to main menu");
        }
    }
}

