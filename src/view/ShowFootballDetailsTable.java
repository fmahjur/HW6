package view;

import model.FootballClub;

import java.util.List;

public class ShowFootballDetailsTable {
    public void displayDetails(FootballClub club){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("| Wins | Defeats | Draws | Goals Received | Goals Scored | Points | Matched Played |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("| "+club.getNumberOFWins()+"    | "+club.getNumberOfDefeats()+"     | "+club.getNumberOfDraws()+"  "
                + "     | "+club.getGoalsReceived()+"              | "+club.getGoalsReceived()+""
                + "            | "+club.getNumberOfPoints()+"      | "+club.getNumberOfPlayed()+"              |");
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void displayLeagueTable(List<FootballClub> football){
        System.out.format("--------------------------");
        System.out.format("| Club Name       |Points|");
        System.out.format("--------------------------");
        for (int i = 0; i < football.size(); i++) {
            System.out.format(football.get(i).getNameOfTheClub(), football.get(i).getNumberOfPoints());
        }
        System.out.format("--------------------------");
    }

}
