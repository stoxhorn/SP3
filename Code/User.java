import java.util.Scanner;

public class User {
    private Scanner input = new Scanner(System.in);
    private String userInput = input.nextLine();

    private void userMenu() {
        System.out.println("Welcome to the user menu. What would you like to do?");
        System.out.println("Type 1 to view the match programme");
        System.out.println("Type 2 to view the teams participating in the tournament");
        System.out.println("Type 3 to view the tournament rules");
        System.out.println("Type 4 to go back to main menu");
        if (userInput == "1") {
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
        }
    }

    
    private void viewTeams() {
       // return teams;
    }

    private void viewMatchProgramme() {
      //  return matchProgramme;
    }

    private void viewTournamentRules() {
        // return tournamentRules
    }
}
