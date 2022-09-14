package ir.maktab.mainHandler;

import ir.maktab.model.entity.VolleyballClub;
import ir.maktab.service.VolleyballClubServiceImpl;
import ir.maktab.service.VolleyballLeagueServiceImpl;

import java.util.Scanner;

import static java.lang.System.exit;

public class VolleyballMenu {
    VolleyballLeagueServiceImpl volleyballLeagueService = new VolleyballLeagueServiceImpl();
    VolleyballClubServiceImpl volleyballClubService = new VolleyballClubServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public void start() throws Exception {
        System.out.println("• 1 : Create a new volleyball club");
        System.out.println("• 2 : Delete a volleyball club");
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

    public void addVolleyballClub() throws Exception {
        VolleyballClub volleyballClub = new VolleyballClub("", 0, 0, 0, 0, 0, 0);
        System.out.print("Please Enter the name of the volleyball club: ");
        volleyballClub.setNameOfTheClub(scanner.next());
        System.out.print("Do you want to add club details info? (Y/N): ");
        String choices = scanner.next();
        if (choices.equalsIgnoreCase("Y")) {
            System.out.print("please enter the number of wins: ");
            volleyballClub.setNumberOFWins(scanner.nextInt());
            System.out.print("please enter the number of defeats: ");
            volleyballClub.setNumberOfDefeats(scanner.nextInt());
            System.out.print("please enter the number of rounds win: ");
            volleyballClub.setNumberOfRoundsWin(scanner.nextInt());
            System.out.print("please enter the number of rounds defeat: ");
            volleyballClub.setNumberOfRoundsDefeat(scanner.nextInt());
            System.out.print("please enter the number of points: ");
            volleyballClub.setNumberOfPoints(scanner.nextInt());
            System.out.print("please enter the number of matches played: ");
            volleyballClub.setNumberOfPlayed(scanner.nextInt());
            volleyballClubService.addClub(volleyballClub);
            addClubToLeague(volleyballClub);
            start();

        } else if (choices.equalsIgnoreCase("N")) {
            volleyballClubService.addClub(volleyballClub);
            addClubToLeague(volleyballClub);
            start();
        } else {
            System.err.println("Please input a valid character!");
            start();
        }
    }

    public void addClubToLeague(VolleyballClub club) throws Exception {
        System.out.print("Do you want to add this club to the league? (Y | N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            volleyballLeagueService.addClub(club);
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
            start();
        }
    }

    public void deleteVolleyballClub() throws Exception {
        System.out.print("List of clubs in this league: ");
        volleyballLeagueService.displayTournamentTable();
        System.out.print("Please Enter the name of the volleyball club you want to delete: ");
        String deletedVolleyballClubName = scanner.next();
        boolean result = volleyballLeagueService.deleteClub(deletedVolleyballClubName);
        if (result) {
            System.out.println(deletedVolleyballClubName + "removed from this tournament!");
        } else {
            System.out.println(deletedVolleyballClubName + "does not exist in this tournament! Please input again");
        }

        System.out.print("Do you want to delete another club? (Y | N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            deleteVolleyballClub();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
        }
    }

    public void showClubDetailsInfo() throws Exception {
        System.out.print("List of clubs in this league: ");
        volleyballLeagueService.showClubsInLeague();
        System.out.print("please enter the club name that you want to see details: ");
        String name = scanner.next();
        volleyballClubService.showClubInfo(name);
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
        volleyballLeagueService.displayTournamentTable();
        System.out.print("Do you want to go back and chose another option? (Y | N): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y"))
            start();
        else
            scanner.close();
    }

    public void addNewPlay() {
        System.out.print("Please enter the name of team1: ");
        String team1 = scanner.next();
        System.out.print("Please enter the name of team2: ");
        String team2 = scanner.next();
        System.out.print("Please enter the number of rounds win by team1: ");
        int roundsWinTeam1 = scanner.nextInt();
        System.out.print("Please enter the number of rounds win by team2: ");
        int roundsWinTeam2 = scanner.nextInt();
        volleyballLeagueService.addPlayAndUpdateScores(team1, team2, roundsWinTeam1, roundsWinTeam2);
    }
}
