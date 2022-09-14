package ir.maktab.view;

import ir.maktab.model.entity.VolleyballClub;
import ir.maktab.service.VolleyballLeagueServiceImpl;

import java.util.Scanner;

import static java.lang.System.exit;

public class VolleyballMenu {
    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("• 1 : Create a new football club");
        System.out.println("• 2 : Delete a football club");
        System.out.println("• 3 : Display the club status");
        System.out.println("• 4 : Display the league Table");
        System.out.println("• 5 : Add a new play and update Score");
        System.out.println("• 6 : Exit");
        System.out.print("Enter your choice : ");
        String choice = scanner.next();
        switch (choice) {
            case "1" -> addVolleyballClub();
            case "2" -> deleteVolleyballClub();
            case "3" -> showClubDetailsInfo();
            case "4" -> displayDetailsOfTeamsINLeague();
            case "5" -> addNewPlay();
            case "6" -> exit(0);
            default -> {
                System.out.println("Invalid input! Please input again!");
                start();
            }
        }

    }

    public void addVolleyballClub() {
        VolleyballClub volleyballClub = new VolleyballClub("", 0, 0, 0, 0, 0, 0);
        System.out.print("Please Enter the name of the volleyball club : ");
        String name = scanner.nextLine();
        System.out.print("Do you want to add club details info? (Y/N):");
        String choices = scanner.nextLine();
        VolleyballLeagueServiceImpl volleyballLeague = new VolleyballLeagueServiceImpl();
        if (choices.equalsIgnoreCase("Y")) {
            System.out.print("please enter the number of wins: ");
            int wins = scanner.nextInt();
            System.out.print("please enter the number of defeats: ");
            int defeats = scanner.nextInt();
            System.out.print("please enter the number of rounds win: ");
            int numberOfRoundsWin = scanner.nextInt();
            System.out.print("please enter the number of rounds defeat: ");
            int numberOfRoundsDefeat = scanner.nextInt();
            System.out.print("please enter the number of points: ");
            int points = scanner.nextInt();
            System.out.print("please enter the number of matches played: ");
            int matches = scanner.nextInt();
            //send the object and other details to the football class
            //volleyballLeague.addClub(volleyballClub, name, wins, defeats, numberOfRoundsWin, numberOfRoundsDefeat, points, matches);
            System.out.println("Do you want to add another club? (Y/N)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                addVolleyballClub();
            } else if (choice.equalsIgnoreCase("N")) {
                start();
            } else {
                System.out.println("Please enter a valid input!");
                start();
            }

            start();

        } else if (choices.equalsIgnoreCase("N")) {
            volleyballLeague.addClub(name);
            start();
        } else {
            System.err.print("Please input a valid character!");
            start();
        }
    }

    public void deleteVolleyballClub() {
        System.out.println("List of clubs in this league:");
        VolleyballLeagueServiceImpl volleyballLeague = new VolleyballLeagueServiceImpl();
        volleyballLeague.displayTournamentTable();
        System.out.println("Please Enter the name of the volleyball club you want to delete : ");
        String deletedClubName = scanner.nextLine();
        boolean result = volleyballLeague.deleteClub(deletedClubName);
        if (result) {
            System.out.println(deletedClubName + "removed from this tournament!");
        } else {
            System.out.println(deletedClubName + "does not exist in this tournament! Please input again");
        }

        System.out.println("Do you want to delete another club? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            deleteVolleyballClub();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
        }
    }

    public void showClubDetailsInfo() {
        System.out.println("List of clubs in this league:");
        VolleyballLeagueServiceImpl volleyballLeague = new VolleyballLeagueServiceImpl();
        volleyballLeague.displayTournamentTable();
        System.out.println("please enter the club name that you want to see details: ");
        String name = scanner.nextLine();
        volleyballLeague.showClubInfo(name);
        System.out.println("Do you want to see another club info? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            showClubDetailsInfo();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
        }
        scanner.close();
    }

    public void displayDetailsOfTeamsINLeague() {
        VolleyballLeagueServiceImpl volleyballLeague = new VolleyballLeagueServiceImpl();
        volleyballLeague.displayTournamentTable();
        System.out.println("Do you want to go back and chose another option? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y"))
            start();
        else
            scanner.close();
    }

    public void addNewPlay() {
        VolleyballLeagueServiceImpl volleyballLeague = new VolleyballLeagueServiceImpl();
        System.out.println("Please enter the name of team1: ");
        String team1 = scanner.nextLine();
        System.out.println("Please enter the name of team2: ");
        String team2 = scanner.nextLine();
        System.out.println("Please enter the number of rounds win by team1: ");
        int roundsWinTeam1 = scanner.nextInt();
        System.out.println("Please enter the number of rounds win by team2: ");
        int roundsWinTeam2 = scanner.nextInt();
        volleyballLeague.addPlayAndUpdateScores(team1, team2, roundsWinTeam1, roundsWinTeam2);
    }
}
