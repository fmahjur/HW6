package service;

import model.FootballClub;
import model.VolleyballClub;
import view.ShowFootballDetailsTable;

import java.util.ArrayList;
import java.util.List;

public class VolleyballLeague implements League {
    static List<VolleyballClub> volleyballClubList = new ArrayList<VolleyballClub>();

    @Override
    public void addClub(String clubName) {
        VolleyballClub volleyballClub = new VolleyballClub(clubName);
        volleyballClubList.add(volleyballClub);
    }

    public void addClub(VolleyballClub club, String nameOfTheClub, int numberOFWins, int numberOfDefeats,
                        int numberOfRoundsWin, int numberOfRoundsDefeat, int numberOfPoints, int numberOfPlayed) {
        club = new VolleyballClub(nameOfTheClub, numberOFWins, numberOfDefeats,
                numberOfRoundsWin, numberOfRoundsDefeat, numberOfPoints, numberOfPlayed);
        volleyballClubList.add(club);
    }

    @Override
    public boolean deleteClub(String clubName) {
        for (int i = 0; i < volleyballClubList.size(); i++) {
            if (volleyballClubList.get(i).getNameOfTheClub().equals(clubName)) {
                volleyballClubList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void addPlay(String club1, String club2) {

    }

    public void addPlayAndUpdateScores(String team1, String team2, int numberOfRoundsWinTeam1, int numberOfRoundsWinTeam2) {
        int deferenceOfPoints = numberOfRoundsWinTeam1 - numberOfRoundsWinTeam2;
        String winnerTeam = "";
        if (deferenceOfPoints >= 1)
            winnerTeam = team1;
        else
            winnerTeam = team2;

        for (int i = 0; i < volleyballClubList.size(); i++) {
            if (volleyballClubList.get(i).getNameOfTheClub().equals(team1)) {
                volleyballClubList.get(i).setNumberOfPlayed(volleyballClubList.get(i).getNumberOfPlayed() + 1);
                volleyballClubList.get(i).setNumberOfRoundsWin(volleyballClubList.get(i).getNumberOfRoundsWin() + numberOfRoundsWinTeam1);
                volleyballClubList.get(i).setNumberOfRoundsDefeat(volleyballClubList.get(i).getNumberOfRoundsDefeat() + numberOfRoundsWinTeam2);
                if (winnerTeam.equals(team1) && deferenceOfPoints >= 2) {
                    volleyballClubList.get(i).setNumberOFWins(volleyballClubList.get(i).getNumberOFWins() + 1);
                    volleyballClubList.get(i).setNumberOfPoints(volleyballClubList.get(i).getNumberOfPoints() + 3);
                } else if (winnerTeam.equals(team1) && deferenceOfPoints == 1) {
                    volleyballClubList.get(i).setNumberOfDraws(volleyballClubList.get(i).getNumberOfDraws() + 1);
                    volleyballClubList.get(i).setNumberOfPoints(volleyballClubList.get(i).getNumberOfPoints() + 2);
                }
            } else if (volleyballClubList.get(i).getNameOfTheClub().equals(team2)) {
                volleyballClubList.get(i).setNumberOfPlayed(volleyballClubList.get(i).getNumberOfPlayed() + 1);
                volleyballClubList.get(i).setNumberOfRoundsWin(volleyballClubList.get(i).getNumberOfRoundsWin() + numberOfRoundsWinTeam2);
                volleyballClubList.get(i).setNumberOfRoundsDefeat(volleyballClubList.get(i).getNumberOfRoundsDefeat() + numberOfRoundsWinTeam1);
                if (winnerTeam.equals(team2) && deferenceOfPoints >= 2) {
                    volleyballClubList.get(i).setNumberOFWins(volleyballClubList.get(i).getNumberOFWins() + 1);
                    volleyballClubList.get(i).setNumberOfPoints(volleyballClubList.get(i).getNumberOfPoints() + 3);
                } else if (winnerTeam.equals(team2) && deferenceOfPoints == 1) {
                    volleyballClubList.get(i).setNumberOfDraws(volleyballClubList.get(i).getNumberOfDraws() + 1);
                    volleyballClubList.get(i).setNumberOfPoints(volleyballClubList.get(i).getNumberOfPoints() + 2);
                }
            }
        }
    }

    public void showClubsInfo() {
        for (int i = 0; i < volleyballClubList.size(); i++) {
            System.out.print(volleyballClubList.get(i).getNameOfTheClub() + " | ");
        }
        System.out.println("");
    }
    @Override
    public void showClubInfo(String clubName) {
        ShowVolleyballDetailsTable tournamentDetailTable = new ShowVolleyballDetailsTable();
        for (int i = 0; i < volleyballClubList.size(); i++) {
            if (volleyballClubList.get(i).getNameOfTheClub().equals(clubName))
                tournamentDetailTable.displayDetails(volleyballClubList.get(i));
        }
    }

    @Override
    public void displayTournamentTable() {
        ShowVoleyballDetailsTable tournamentDetailTable = new ShowVoleyballDetailsTable();
        tournamentDetailTable.displayLeagueTable(volleyballClubList);

    }
}
