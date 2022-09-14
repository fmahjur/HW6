package ir.maktab;

import ir.maktab.model.entity.FootballClub;
import ir.maktab.model.entity.VolleyballClub;
import ir.maktab.view.FootballMenu;
import ir.maktab.view.VolleyballMenu;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        VolleyballClub volleyballClub = new VolleyballClub("vTest", 4, 5, 9, 5, 5, 4);
        System.out.println(volleyballClub.toStringForLeagueTable());
        FootballClub footballClub = new FootballClub("fTest", 4, 5, 3, 4, 5, 8, 6);
        System.out.println(footballClub.toStringForLeagueTable());

        Scanner scanner = new Scanner(System.in);
        System.out.println("• 1 : Football League");
        System.out.println("• 2 : Volleyball League");
        System.out.println("• 3 : Exit");
        System.out.print("Enter your choice : ");
        String choice;
        choice = scanner.next();
        switch (choice) {
            case "1" -> {
                FootballMenu startFootballMenu = new FootballMenu();
                startFootballMenu.start();
            }
            case "2" -> {
                VolleyballMenu startVolleyballMenu = new VolleyballMenu();
                startVolleyballMenu.start();
            }
            case "3" -> exit(0);
            default -> System.out.println("Invalid input! Please input again!");
        }
    }
}
