package ir.maktab.service;

import ir.maktab.model.entity.FootballClub;
import ir.maktab.service.interfaces.LeagueService;
import ir.maktab.view.ShowFootballDetailsTable;

import java.util.ArrayList;
import java.util.List;

public class FootballLeagueServiceImpl implements LeagueService {
    static List<FootballClub> footballClubList = new ArrayList<>();

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

        for (FootballClub club : footballClubList) {
            if (club.getNameOfTheClub().equals(team1)) {
                club.setNumberOfPlayed(club.getNumberOfPlayed() + 1);
                club.setGoalsScored(club.getGoalsScored() + goalsScoredByTeam1);
                club.setGoalsReceived(club.getGoalsReceived() + goalsScoredByTeam2);
                if (winnerTeam.equals(team1)) {
                    club.setNumberOFWins(club.getNumberOFWins() + 1);
                    club.setNumberOfPoints(club.getNumberOfPoints() + 3);
                } else if (winnerTeam.equals("")) {
                    club.setNumberOfDraws(club.getNumberOfDraws() + 1);
                    club.setNumberOfPoints(club.getNumberOfPoints() + 3);
                }
            } else if (club.getNameOfTheClub().equals(team2)) {
                club.setNumberOfPlayed(club.getNumberOfPlayed() + 1);
                club.setGoalsScored(club.getGoalsScored() + goalsScoredByTeam2);
                club.setGoalsReceived(club.getGoalsReceived() + goalsScoredByTeam1);
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


    public void showClubsInfo() {
        for (FootballClub club : footballClubList) {
            System.out.print(club.getNameOfTheClub() + " | ");
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
