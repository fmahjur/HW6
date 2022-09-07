package service;

import model.FootballClub;
import view.ShowFootballDetailsTable;

import java.util.ArrayList;
import java.util.List;

public class FootballLeague implements League {
    static List<FootballClub> football = new ArrayList<FootballClub>();

    @Override
    public void addClub(String clubName) {
        FootballClub footballClub = new FootballClub(clubName);
        football.add(footballClub);
    }

    public void addClub(FootballClub club, String nameOfTheClub, int numberOFWins, int numberOfDefeats, int numberOfDraws,
                        int goalsReceived, int goalsScored, int numberOfPoints, int numberOfPlayed) {
        club = new FootballClub(nameOfTheClub, numberOFWins, numberOfDefeats, numberOfDraws,
                goalsReceived, goalsScored, numberOfPoints, numberOfPlayed);
        football.add(club);
    }

    @Override
    public boolean deleteClub(String name) {
        for (int i = 0; i < football.size(); i++) {
            if (football.get(i).getNameOfTheClub().equals(name)) {
                football.remove(i);
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

        for (int i = 0; i < football.size(); i++) {
            if (football.get(i).getNameOfTheClub().equals(team1)) {
                football.get(i).setNumberOfPlayed(football.get(i).getNumberOfPlayed() + 1);
                football.get(i).setGoalsScored(football.get(i).getGoalsScored() + goalsScoredByTeam1);
                football.get(i).setGoalsReceived(football.get(i).getGoalsReceived() + goalsScoredByTeam2);
                if (winnerTeam.equals(team1)) {
                    football.get(i).setNumberOFWins(football.get(i).getNumberOFWins() + 1);
                    football.get(i).setNumberOfPoints(football.get(i).getNumberOfPoints() + 3);
                } else if (winnerTeam.equals("")) {
                    football.get(i).setNumberOfDraws(football.get(i).getNumberOfDraws() + 1);
                    football.get(i).setNumberOfPoints(football.get(i).getNumberOfPoints() + 3);
                }
            } else if (football.get(i).getNameOfTheClub().equals(team2)) {
                football.get(i).setNumberOfPlayed(football.get(i).getNumberOfPlayed() + 1);
                football.get(i).setGoalsScored(football.get(i).getGoalsScored() + goalsScoredByTeam2);
                football.get(i).setGoalsReceived(football.get(i).getGoalsReceived() + goalsScoredByTeam1);
                if (winnerTeam.equals(team2)) {
                    football.get(i).setNumberOFWins(football.get(i).getNumberOFWins() + 1);
                    football.get(i).setNumberOfPoints(football.get(i).getNumberOfPoints() + 3);
                } else if (winnerTeam.equals("")) {
                    football.get(i).setNumberOfDraws(football.get(i).getNumberOfDraws() + 1);
                    football.get(i).setNumberOfPoints(football.get(i).getNumberOfPoints() + 3);
                }
            }
        }
    }


    public void showClubsInfo() {
        for (int i = 0; i < football.size(); i++) {
            System.out.print(football.get(i).getNameOfTheClub() + " | ");
        }
        System.out.println("");
    }

    @Override
    public void showClubInfo(String name) {
        ShowFootballDetailsTable tournamentDetailTable = new ShowFootballDetailsTable();
        for (int i = 0; i < football.size(); i++) {
            if (football.get(i).getNameOfTheClub().equals(name))
                tournamentDetailTable.displayDetails(football.get(i));
        }
    }

    @Override
    public void displayTournamentTable() {
        ShowFootballDetailsTable tournamentDetailTable = new ShowFootballDetailsTable();
        tournamentDetailTable.displayLeagueTable(football);
    }
}
