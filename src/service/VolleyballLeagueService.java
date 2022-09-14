package service;

import model.VolleyballClub;
import view.ShowVolleyballDetailsTable;

import java.util.ArrayList;
import java.util.List;

public class VolleyballLeagueService implements LeagueService {
    static List<VolleyballClub> volleyballClubList = new ArrayList<>();

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
        String winnerTeam;
        if (deferenceOfPoints >= 1)
            winnerTeam = team1;
        else
            winnerTeam = team2;

        for (VolleyballClub volleyballClub : volleyballClubList) {
            if (volleyballClub.getNameOfTheClub().equals(team1)) {
                volleyballClub.setNumberOfPlayed(volleyballClub.getNumberOfPlayed() + 1);
                volleyballClub.setNumberOfRoundsWin(volleyballClub.getNumberOfRoundsWin() + numberOfRoundsWinTeam1);
                volleyballClub.setNumberOfRoundsDefeat(volleyballClub.getNumberOfRoundsDefeat() + numberOfRoundsWinTeam2);
                if (winnerTeam.equals(team1) && deferenceOfPoints >= 2) {
                    volleyballClub.setNumberOFWins(volleyballClub.getNumberOFWins() + 1);
                    volleyballClub.setNumberOfPoints(volleyballClub.getNumberOfPoints() + 3);
                } else if (winnerTeam.equals(team1) && deferenceOfPoints == 1) {
                    volleyballClub.setNumberOfDraws(volleyballClub.getNumberOfDraws() + 1);
                    volleyballClub.setNumberOfPoints(volleyballClub.getNumberOfPoints() + 2);
                }
            } else if (volleyballClub.getNameOfTheClub().equals(team2)) {
                volleyballClub.setNumberOfPlayed(volleyballClub.getNumberOfPlayed() + 1);
                volleyballClub.setNumberOfRoundsWin(volleyballClub.getNumberOfRoundsWin() + numberOfRoundsWinTeam2);
                volleyballClub.setNumberOfRoundsDefeat(volleyballClub.getNumberOfRoundsDefeat() + numberOfRoundsWinTeam1);
                if (winnerTeam.equals(team2) && deferenceOfPoints >= 2) {
                    volleyballClub.setNumberOFWins(volleyballClub.getNumberOFWins() + 1);
                    volleyballClub.setNumberOfPoints(volleyballClub.getNumberOfPoints() + 3);
                } else if (winnerTeam.equals(team2) && deferenceOfPoints == 1) {
                    volleyballClub.setNumberOfDraws(volleyballClub.getNumberOfDraws() + 1);
                    volleyballClub.setNumberOfPoints(volleyballClub.getNumberOfPoints() + 2);
                }
            }
        }
    }

    public void showClubsInfo() {
        for (VolleyballClub volleyballClub : volleyballClubList) {
            System.out.print(volleyballClub.getNameOfTheClub() + " | ");
        }
        System.out.println();
    }

    @Override
    public void showClubInfo(String clubName) {
        ShowVolleyballDetailsTable tournamentDetailTable = new ShowVolleyballDetailsTable();
        for (VolleyballClub volleyballClub : volleyballClubList) {
            if (volleyballClub.getNameOfTheClub().equals(clubName))
                tournamentDetailTable.displayDetails(volleyballClub);
        }
    }

    @Override
    public void displayTournamentTable() {
        ShowVolleyballDetailsTable tournamentDetailTable = new ShowVolleyballDetailsTable();
        tournamentDetailTable.displayLeagueTable(volleyballClubList);
    }
}
