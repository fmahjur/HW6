package ir.maktab.mainHandler;

import ir.maktab.model.entity.FootballClub;
import ir.maktab.service.FootballClubServiceImpl;
import ir.maktab.service.FootballLeagueServiceImpl;

import java.util.Scanner;

import static java.lang.System.exit;

public class FootballMenu {
    FootballLeagueServiceImpl footballLeagueService = new FootballLeagueServiceImpl();
    FootballClubServiceImpl footballClubService = new FootballClubServiceImpl();

    Scanner scanner = new Scanner(System.in);

    public void start() throws Exception {
        System.out.println("• 1 : Create a new football club");
        System.out.println("• 2 : Delete a football club");
        System.out.println("• 3 : Display the club status");
        System.out.println("• 4 : Display the league Table");
        System.out.println("• 5 : Add a new play and update Score");
        System.out.println("• 6 : Exit");
        System.out.print("Enter your choice: ");
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

    public void addFootballClub() throws Exception {
        FootballClub football = new FootballClub("", 0, 0, 0, 0, 0, 0, 0);
        System.out.print("Please Enter the name of the football club: ");
        football.setNameOfTheClub(scanner.next());
        System.out.print("Do you want to add club details info? (Y | N): ");
        String choices = scanner.next();
        if (choices.equalsIgnoreCase("Y")) {
            System.out.print("please enter the number of wins: ");
            football.setNumberOFWins(scanner.nextInt());
            System.out.print("please enter the number of defeats: ");
            football.setNumberOfDefeats(scanner.nextInt());
            System.out.print("please enter the number of draws: ");
            football.setNumberOfDraws(scanner.nextInt());
            System.out.print("please enter the number of goals received: ");
            football.setGoalsReceived(scanner.nextInt());
            System.out.print("please enter the number of goals scored: ");
            football.setGoalsScored(scanner.nextInt());
            System.out.print("please enter the number of points: ");
            football.setNumberOfPoints(scanner.nextInt());
            System.out.print("please enter the number of matches played: ");
            football.setNumberOfPlayed(scanner.nextInt());
            footballClubService.addClub(football);
            addClubToLeague(football);
            start();
        } else if (choices.equalsIgnoreCase("N")) {
            footballClubService.addClub(football);
            addClubToLeague(football);
            start();
        } else {
            System.err.println("Please input a valid character!");
            start();
        }
    }

    public void addClubToLeague(FootballClub club) throws Exception {
        System.out.print("Do you want to add this club to the Football league? (Y | N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            footballLeagueService.addClub(club);
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
            start();
        }
    }

    public void deleteFootballClub() throws Exception {
        System.out.print("List of clubs in this league: ");
        footballLeagueService.showClubsInLeague();
        System.out.print("Please Enter the name of the football club you want to delete: ");
        String deletedFootballClubName = scanner.next();
        boolean result = footballLeagueService.deleteClub(deletedFootballClubName);
        if (result) {
            System.out.println(deletedFootballClubName + "removed from this tournament!");
        } else {
            System.out.println(deletedFootballClubName + "does not exist in this tournament! Please input again");
        }

        System.out.print("Do you want to delete another club? (Y | N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            deleteFootballClub();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
        }
    }

    public void showClubDetailsInfo() throws Exception {
        System.out.print("List of clubs in this Football league: ");
        footballLeagueService.showClubsInLeague();
        System.out.print("please enter the club name that you want to see details: ");
        String clubName = scanner.next();
        footballClubService.showClubInfo(clubName);
        System.out.print("Do you want to see another club info? (Y | N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            showClubDetailsInfo();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
        }
        scanner.close();
    }

    public void displayDetailsOfTeamsINLeague() throws Exception {
        footballLeagueService.displayTournamentTable();
        System.out.print("Do you want to go back and chose another option? (Y | N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y"))
            start();
        else
            scanner.close();
    }

    public void addNewPlay() {
        System.out.print("Please enter the name of team1: ");
        String team1 = scanner.nextLine();
        System.out.print("Please enter the name of team2: ");
        String team2 = scanner.nextLine();
        System.out.print("Please enter the number of goals scored by team1: ");
        int goalsScoredByTeam1 = scanner.nextInt();
        System.out.print("Please enter the number of goals scored by team2: ");
        int goalsScoredByTeam2 = scanner.nextInt();
        footballLeagueService.addPlayAndUpdateScores(team1, team2, goalsScoredByTeam1, goalsScoredByTeam2);
    }
}
