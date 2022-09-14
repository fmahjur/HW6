package ir.maktab.view;

import ir.maktab.model.entity.FootballClub;
import ir.maktab.service.FootballLeagueServiceImpl;

import java.util.Scanner;

import static java.lang.System.exit;

public class FootballMenu {
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
            case "1" -> addFootballClub();
            case "2" -> deleteFootballClub();
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

    public void addFootballClub() {
        FootballClub football = new FootballClub("", 0, 0, 0, 0, 0, 0, 0);
        System.out.print("Please Enter the name of the football club : ");
        String name = (scanner.nextLine());
        System.out.print("Do you want to add club details info? (Y/N):");
        String choices = scanner.nextLine();
        FootballLeagueServiceImpl club = new FootballLeagueServiceImpl();
        if (choices.equalsIgnoreCase("Y")) {
            System.out.print("please enter the number of wins: ");
            int wins = scanner.nextInt();
            System.out.print("please enter the number of defeats: ");
            int defeats = scanner.nextInt();
            System.out.print("please enter the number of draws: ");
            int draws = scanner.nextInt();
            System.out.print("please enter the number of goals received: ");
            int goalsReceived = scanner.nextInt();
            System.out.print("please enter the number of goals scored: ");
            int defeatsScored = scanner.nextInt();
            System.out.print("please enter the number of points: ");
            int points = scanner.nextInt();
            System.out.print("please enter the number of matches played: ");
            int matches = scanner.nextInt();
            //send the object and other details to the football class
            club.addClub(football, name, wins, defeats, draws, goalsReceived, defeatsScored, points, matches);
            System.out.println("Do you want to add another club? (Y/N)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                addFootballClub();
            } else if (choice.equalsIgnoreCase("N")) {
                start();
            } else {
                System.out.println("Please enter a valid input!");
                start();
            }

            start();

        } else if (choices.equalsIgnoreCase("N")) {
            club.addClub(name);
            start();
        } else {
            System.err.print("Please input a valid character!");
            start();
        }
    }

    public void deleteFootballClub() {
        System.out.println("List of clubs in this league:");
        FootballLeagueServiceImpl football = new FootballLeagueServiceImpl();
        football.displayTournamentTable();
        System.out.println("Please Enter the name of the football club you want to delete : ");
        String deletedClubName = scanner.nextLine();
        boolean result = football.deleteClub(deletedClubName);
        if (result) {
            System.out.println(deletedClubName + "removed from this tournament!");
        } else {
            System.out.println(deletedClubName + "does not exist in this tournament! Please input again");
        }

        System.out.println("Do you want to delete another club? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            deleteFootballClub();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
        }
    }

    public void showClubDetailsInfo() {
        System.out.println("List of clubs in this league:");
        FootballLeagueServiceImpl football = new FootballLeagueServiceImpl();
        football.displayTournamentTable();
        System.out.println("please enter the club name that you want to see details: ");
        String name = scanner.nextLine();
        football.showClubInfo(name);
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
        FootballLeagueServiceImpl footballLeague = new FootballLeagueServiceImpl();
        footballLeague.displayTournamentTable();
        System.out.println("Do you want to go back and chose another option? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y"))
            start();
        else
            scanner.close();
    }

    public void addNewPlay() {
        FootballLeagueServiceImpl footballLeague = new FootballLeagueServiceImpl();
        System.out.println("Please enter the name of team1: ");
        String team1 = scanner.nextLine();
        System.out.println("Please enter the name of team2: ");
        String team2 = scanner.nextLine();
        System.out.println("Please enter the number of goals scored by team1: ");
        int goalsScoredByTeam1 = scanner.nextInt();
        System.out.println("Please enter the number of goals scored by team2: ");
        int goalsScoredByTeam2 = scanner.nextInt();
        footballLeague.addPlayAndUpdateScores(team1, team2, goalsScoredByTeam1, goalsScoredByTeam2);
    }
}
