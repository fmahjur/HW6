import view.FootballMenu;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("• 1 : Football League");
        System.out.println("• 2 : Volleyball League");
        System.out.println("• 3 : Exit");
        System.out.print("Enter your choice : ");
        String choice;
        choice = sc.next();
        switch (choice) {
            case "1":
                FootballMenu start = new FootballMenu();
                start.start();
                break;
            case "2":
                break;
            case "3":
                exit(0);
                break;
            default:
                System.out.println("Invalid input! Please input again!");
        }
    }
}
