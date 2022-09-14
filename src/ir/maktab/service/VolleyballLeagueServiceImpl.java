package ir.maktab.service;

import ir.maktab.model.entity.VolleyballClub;
import ir.maktab.service.interfaces.LeagueService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VolleyballLeagueServiceImpl implements LeagueService {
    static List<VolleyballClub> volleyballClubList = new ArrayList<>();
    static List<VolleyballClub> sortedVolleyballClubList;

    @Override
    public void addClub(String clubName) {
        VolleyballClub volleyballClub = new VolleyballClub(clubName);
        volleyballClubList.add(volleyballClub);
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

    @Override
    public void sortedClubsByPoint() {
        Comparator<VolleyballClub> compareByPoints = Comparator.comparing(VolleyballClub::getNumberOfPoints)
                .thenComparing(VolleyballClub::getNumberOfRoundsWin)
                .thenComparing(VolleyballClub::getNumberOfRoundsDefeat);
        sortedVolleyballClubList = volleyballClubList.stream()
                .sorted(compareByPoints).toList();
    }

    @Override
    public void showClubsInLeague() {
        sortedClubsByPoint();
        String alignFormat = "| %-15s | %-4d |%n";
        System.out.println("--------------------------%n");
        System.out.println("|   club name   | points |%n");
        System.out.println("--------------------------%n");
        for (VolleyballClub club : sortedVolleyballClubList) {
            System.out.format(alignFormat, club.getNameOfTheClub() + "|" + club.getNumberOfPoints());
            System.out.println("--------------------------%n");
        }
        System.out.println();
    }

    @Override
    public void displayTournamentTable() {
        sortedClubsByPoint();
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.println("\"| numberOfRoundsWin | numberOfRoundsDefeat | numberOfWins | numberOfDefeats | numberOfPoints | numberOfPlayed |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        for (VolleyballClub club : sortedVolleyballClubList) {
            System.out.println(club.toStringForLeagueTable());
            System.out.println("-------------------------------------------------------------------------------------------------------------");
        }
        System.out.println();
    }
}
