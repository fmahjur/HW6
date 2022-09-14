package view;

import model.entity.VolleyballClub;

import java.util.List;

public class ShowVolleyballDetailsTable {
    public void displayDetails(VolleyballClub club) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("| Wins | Defeats | RoundsWin | RoundsDefeat | Points | MatchedPlayed |");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("| " + club.getNumberOFWins() + "    | " + club.getNumberOfDefeats() + "       | " + club.getNumberOfRoundsWin() + ""
                + "         | " + club.getNumberOfRoundsDefeat() + "            | " + club.getNumberOfPoints() + "      | " + club.getNumberOfPlayed() + "             |");
        System.out.println("-----------------------------------------------------------------------");
    }

    public void displayLeagueTable(List<VolleyballClub> volleyball) {
        System.out.println("--------------------------");
        System.out.println("| Club Name       |Points|");
        System.out.println("--------------------------");
        for (int i = 0; i < volleyball.size(); i++) {
            System.out.format(volleyball.get(i).getNameOfTheClub(), volleyball.get(i).getNumberOfPoints());
        }
        System.out.format("--------------------------");
    }

}
