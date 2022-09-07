import view.FootballMenu;
import view.VolleyballMenu;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("• 1 : Football League");
        System.out.println("• 2 : Volleyball League");
        System.out.println("• 3 : Exit");
        System.out.print("Enter your choice : ");
        String choice;
        choice = scanner.next();
        switch (choice) {
            case "1":
                FootballMenu startFootballMenu = new FootballMenu();
                startFootballMenu.start();
                break;
            case "2":
                VolleyballMenu startVolleyballMenu = new VolleyballMenu();
                startVolleyballMenu.start();
                break;
            case "3":
                exit(0);
                break;
            default:
                System.out.println("Invalid input! Please input again!");
        }
    }
}
