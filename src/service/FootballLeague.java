package service;

import model.FootballClub;
import view.ShowFootballDetailsTable;

import java.util.ArrayList;
import java.util.List;

public class FootballLeague implements League {
    static List<FootballClub> football = new ArrayList<FootballClub>();

    public void addClub(String nameOfTheClub, int numberOFWins, int numberOfDefeats,
                        int goalsReceived, int goalsScored, int numberOfPoints, int numberOfPlayed) {
        FootballClub club = new FootballClub(nameOfTheClub, numberOFWins, numberOfDefeats, goalsReceived,
                goalsScored, numberOfPoints, numberOfPlayed);
        football.add(club);
    }

    @Override
    public void addClub() {

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

    @Override
    public void showClubsInfo(String name) {
        for (int i = 0; i < football.size(); i++) {
            System.out.print(football.get(i).getNameOfTheClub() + " | ");
        }
        System.out.println("");

    }

    @Override
    public void displayTournamentTable() {
        ShowFootballDetailsTable tournamentDetailTable = new ShowFootballDetailsTable();
        tournamentDetailTable.displayLeagueTable(football);
    }
}
