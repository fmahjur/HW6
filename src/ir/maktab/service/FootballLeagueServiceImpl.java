package ir.maktab.service;

import ir.maktab.model.entity.FootballClub;
import ir.maktab.service.compare.SortByPoints;
import ir.maktab.service.interfaces.LeagueService;
import ir.maktab.view.ShowFootballDetailsTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FootballLeagueServiceImpl implements LeagueService {
    static List<FootballClub> footballClubList = new ArrayList<>();

    @Override
    public void addClub(String clubName) {
        FootballClub footballClub = new FootballClub(clubName);
        footballClubList.add(footballClub);
    }

    @Override
    public boolean deleteClub(String name) {
        for (int i = 0; i < footballClubList.size(); i++) {
            if (footballClubList.get(i).getNameOfTheClub().equals(name)) {
                footballClubList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void addPlayAndUpdateScores(String team1, String team2, int scoredByTeam1, int scoredByTeam2) {
        String winnerTeam = "";
        if (scoredByTeam1 > scoredByTeam2)
            winnerTeam = team1;
        else if (scoredByTeam2 > scoredByTeam1)
            winnerTeam = team2;

        for (FootballClub club : footballClubList) {
            if (club.getNameOfTheClub().equals(team1)) {
                club.setNumberOfPlayed(club.getNumberOfPlayed() + 1);
                club.setGoalsScored(club.getGoalsScored() + scoredByTeam1);
                club.setGoalsReceived(club.getGoalsReceived() + scoredByTeam2);
                if (winnerTeam.equals(team1)) {
                    club.setNumberOFWins(club.getNumberOFWins() + 1);
                    club.setNumberOfPoints(club.getNumberOfPoints() + 3);
                } else if (winnerTeam.equals("")) {
                    club.setNumberOfDraws(club.getNumberOfDraws() + 1);
                    club.setNumberOfPoints(club.getNumberOfPoints() + 3);
                }
            } else if (club.getNameOfTheClub().equals(team2)) {
                club.setNumberOfPlayed(club.getNumberOfPlayed() + 1);
                club.setGoalsScored(club.getGoalsScored() + scoredByTeam2);
                club.setGoalsReceived(club.getGoalsReceived() + scoredByTeam1);
                if (winnerTeam.equals(team2)) {
                    club.setNumberOFWins(club.getNumberOFWins() + 1);
                    club.setNumberOfPoints(club.getNumberOfPoints() + 3);
                } else if (winnerTeam.equals("")) {
                    club.setNumberOfDraws(club.getNumberOfDraws() + 1);
                    club.setNumberOfPoints(club.getNumberOfPoints() + 3);
                }
            }
        }
    }


    public void showClubsInLeague() {
        Collections.sort(footballClubList, new SortByPoints());
        String alignFormat = "| %-15s | %-4d |%n";
        System.out.println("--------------------------%n");
        System.out.println("|   club name   | points |%n");
        System.out.println("--------------------------%n");
        for (FootballClub club : footballClubList) {
            System.out.format(alignFormat, club.getNameOfTheClub() + "|" + club.getNumberOfPoints());
            System.out.println("--------------------------%n");
        }
        System.out.println();
    }

    @Override
    public void showClubInfo(String name) {
        ShowFootballDetailsTable tournamentDetailTable = new ShowFootballDetailsTable();
        for (FootballClub club : footballClubList) {
            if (club.getNameOfTheClub().equals(name))
                tournamentDetailTable.displayDetails(club);
        }
    }

    @Override
    public void displayTournamentTable() {
        ShowFootballDetailsTable tournamentDetailTable = new ShowFootballDetailsTable();
        tournamentDetailTable.displayLeagueTable(footballClubList);
    }
}
