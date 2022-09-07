package service;

import model.FootballClub;
import view.ShowFootballDetailsTable;

import java.util.ArrayList;
import java.util.List;

public class FootballLeague implements League {
    static List<FootballClub> footballClubList = new ArrayList<FootballClub>();

    @Override
    public void addClub(String clubName) {
        FootballClub footballClub = new FootballClub(clubName);
        footballClubList.add(footballClub);
    }

    public void addClub(FootballClub club, String nameOfTheClub, int numberOFWins, int numberOfDefeats, int numberOfDraws,
                        int goalsReceived, int goalsScored, int numberOfPoints, int numberOfPlayed) {
        club = new FootballClub(nameOfTheClub, numberOFWins, numberOfDefeats, numberOfDraws,
                goalsReceived, goalsScored, numberOfPoints, numberOfPlayed);
        footballClubList.add(club);
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
    public void addPlay(String club1, String club2) {
    }

    public void addPlayAndUpdateScores(String team1, String team2, int goalsScoredByTeam1, int goalsScoredByTeam2) {
        String winnerTeam = "";
        if (goalsScoredByTeam1 > goalsScoredByTeam2)
            winnerTeam = team1;
        else if (goalsScoredByTeam2 > goalsScoredByTeam1)
            winnerTeam = team2;

        for (int i = 0; i < footballClubList.size(); i++) {
            if (footballClubList.get(i).getNameOfTheClub().equals(team1)) {
                footballClubList.get(i).setNumberOfPlayed(footballClubList.get(i).getNumberOfPlayed() + 1);
                footballClubList.get(i).setGoalsScored(footballClubList.get(i).getGoalsScored() + goalsScoredByTeam1);
                footballClubList.get(i).setGoalsReceived(footballClubList.get(i).getGoalsReceived() + goalsScoredByTeam2);
                if (winnerTeam.equals(team1)) {
                    footballClubList.get(i).setNumberOFWins(footballClubList.get(i).getNumberOFWins() + 1);
                    footballClubList.get(i).setNumberOfPoints(footballClubList.get(i).getNumberOfPoints() + 3);
                } else if (winnerTeam.equals("")) {
                    footballClubList.get(i).setNumberOfDraws(footballClubList.get(i).getNumberOfDraws() + 1);
                    footballClubList.get(i).setNumberOfPoints(footballClubList.get(i).getNumberOfPoints() + 3);
                }
            } else if (footballClubList.get(i).getNameOfTheClub().equals(team2)) {
                footballClubList.get(i).setNumberOfPlayed(footballClubList.get(i).getNumberOfPlayed() + 1);
                footballClubList.get(i).setGoalsScored(footballClubList.get(i).getGoalsScored() + goalsScoredByTeam2);
                footballClubList.get(i).setGoalsReceived(footballClubList.get(i).getGoalsReceived() + goalsScoredByTeam1);
                if (winnerTeam.equals(team2)) {
                    footballClubList.get(i).setNumberOFWins(footballClubList.get(i).getNumberOFWins() + 1);
                    footballClubList.get(i).setNumberOfPoints(footballClubList.get(i).getNumberOfPoints() + 3);
                } else if (winnerTeam.equals("")) {
                    footballClubList.get(i).setNumberOfDraws(footballClubList.get(i).getNumberOfDraws() + 1);
                    footballClubList.get(i).setNumberOfPoints(footballClubList.get(i).getNumberOfPoints() + 3);
                }
            }
        }
    }


    public void showClubsInfo() {
        for (int i = 0; i < footballClubList.size(); i++) {
            System.out.print(footballClubList.get(i).getNameOfTheClub() + " | ");
        }
        System.out.println("");
    }

    @Override
    public void showClubInfo(String name) {
        ShowFootballDetailsTable tournamentDetailTable = new ShowFootballDetailsTable();
        for (int i = 0; i < footballClubList.size(); i++) {
            if (footballClubList.get(i).getNameOfTheClub().equals(name))
                tournamentDetailTable.displayDetails(footballClubList.get(i));
        }
    }

    @Override
    public void displayTournamentTable() {
        ShowFootballDetailsTable tournamentDetailTable = new ShowFootballDetailsTable();
        tournamentDetailTable.displayLeagueTable(footballClubList);
    }
}
