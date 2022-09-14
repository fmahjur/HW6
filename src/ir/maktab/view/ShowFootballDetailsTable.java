package ir.maktab.view;

import ir.maktab.entity.FootballClub;

import java.util.List;

public class ShowFootballDetailsTable {
    public void displayDetails(FootballClub club) {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("| Wins | Defeats | Draws | Goals Received | Goals Scored | Points | Matched Played |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("| " + club.getNumberOFWins() + "    | " + club.getNumberOfDefeats() + "     | " + club.getNumberOfDraws() + "  "
                + "     | " + club.getGoalsReceived() + "              | " + club.getGoalsReceived() + ""
                + "            | " + club.getNumberOfPoints() + "      | " + club.getNumberOfPlayed() + "              |");
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void displayLeagueTable(List<FootballClub> football) {
        System.out.println("--------------------------");
        System.out.println("| Club Name       |Points|");
        System.out.println("--------------------------");
        for (int i = 0; i < football.size(); i++) {
            System.out.format(football.get(i).getNameOfTheClub(), football.get(i).getNumberOfPoints());
        }
        System.out.format("--------------------------");
    }

}
