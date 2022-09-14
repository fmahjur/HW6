package ir.maktab.service.interfaces;

import ir.maktab.model.entity.SportClub;

public interface LeagueService {

    boolean deleteClub(String clubName);

    void addPlayAndUpdateScores(String club1, String club2, int scoredByTeam1, int scoredByTeam2);

    void sortedClubsByPoint();

    void showClubsInLeague();

    void displayTournamentTable();

}
