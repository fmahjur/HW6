package view;

import model.FootballClub;
import service.FootballLeague;

import java.util.Scanner;

import static java.lang.System.exit;

public class FootballMenu {
    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("• 1 : Create a new football club");
        System.out.println("• 2 : Delete a football club");
        System.out.println("• 3 : Display the club status");
        System.out.println("• 4 : Display the league Table");
        System.out.println("• 5 : Add a new play and update Score");
        System.out.println("• 6 : Exit");
        System.out.print("Enter your choice : ");
        String choice = sc.next();
        switch (choice) {
            case "1":
                addFootballClub();
                break;
            case "2":
                deleteFootballClub();
                break;
            case "3":
                showClubDetailsInfo();
                break;
            case "4":
                displayDetailsOfTeamsINLeague();
                break;
            case "5":
                addNewPlay();
                break;
            case "6":
                exit(0);
                break;
            default:
                System.out.println("Invalid input! Please input again!");
                start();
        }

    }

    public void addFootballClub() {
        Scanner sc1 = new Scanner(System.in);
        FootballClub football = new FootballClub("", 0, 0, 0, 0, 0, 0, 0);
        System.out.print("Please Enter the name of the football club : ");
        String name = (sc1.nextLine());
        System.out.print("Do you want to add club details info? (Y/N):");
        String choices = sc1.nextLine();
        FootballLeague club = new FootballLeague();
        if (choices.equalsIgnoreCase("Y")) {
            System.out.print("please enter the number of wins: ");
            int wins = sc1.nextInt();
            System.out.print("please enter the number of defeats: ");
            int defeats = sc1.nextInt();
            System.out.print("please enter the number of draws: ");
            int draws = sc1.nextInt();
            System.out.print("please enter the number of goals received: ");
            int goalsReceived = sc1.nextInt();
            System.out.print("please enter the number of goals scored: ");
            int defeatsScored = sc1.nextInt();
            System.out.print("please enter the number of points: ");
            int points = sc1.nextInt();
            System.out.print("please enter the number of matches played: ");
            int matches = sc1.nextInt();
            //send the object and other details to the football class
            club.addClub(football, name, wins, defeats, draws, goalsReceived, defeatsScored, points, matches);
            System.out.println("Do you want to add another club? (Y/N)");
            String choice = sc1.nextLine();

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
        Scanner sc = new Scanner(System.in);
        System.out.println("List of clubs in this league:");
        FootballLeague football = new FootballLeague();
        football.displayTournamentTable();
        System.out.println("Please Enter the name of the football club you want to delete : ");
        String deletedClubName = sc.nextLine();
        FootballLeague club = new FootballLeague();
        boolean result = club.deleteClub(deletedClubName);
        if (result == true) {
            System.out.println(deletedClubName + "removed from this tournament!");
        } else {
            System.out.println(deletedClubName + "does not exist in this tournament! Please input again");
        }

        System.out.println("Do you want to delete another club? (Y/N)");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            deleteFootballClub();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
        }
    }

    public void showClubDetailsInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("List of clubs in this league:");
        FootballLeague football = new FootballLeague();
        football.displayTournamentTable();
        System.out.println("please enter the club name that you want to see details: ");
        String name = sc.nextLine();
        football.showClubInfo(name);
        System.out.println("Do you want to see another club info? (Y/N)");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            showClubDetailsInfo();
        } else if (choice.equalsIgnoreCase("N")) {
            start();
        } else {
            System.out.println("Please enter a valid input!");
        }
        sc.close();
    }

    public void displayDetailsOfTeamsINLeague() {
        Scanner sc = new Scanner(System.in);
        FootballLeague footballLeague = new FootballLeague();
        footballLeague.displayTournamentTable();
        System.out.println("Do you want to go back and chose another option? (Y/N)");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("Y"))
            start();
        else
            sc.close();
    }

    public void addNewPlay() {
        Scanner sc = new Scanner(System.in);
        FootballLeague footballLeague = new FootballLeague();
        System.out.println("Please enter the name of team1: ");
        String team1 = sc.nextLine();
        System.out.println("Please enter the name of team2: ");
        String team2 = sc.nextLine();
        System.out.println("Please enter the number of goals scored by team1: ");
        int goalsScoredByTeam1 = sc.nextInt();
        System.out.println("Please enter the number of goals scored by team2: ");
        int goalsScoredByTeam2 = sc.nextInt();
        footballLeague.addPlayAndUpdateScores(team1, team2, goalsScoredByTeam1, goalsScoredByTeam2);
    }
}
