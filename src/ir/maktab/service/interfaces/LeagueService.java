package ir.maktab.service.interfaces;

public interface LeagueService {
    void addClub(String clubName);

    boolean deleteClub(String clubName);

    void addPlayAndUpdateScores(String club1, String club2, int scoredByTeam1, int scoredByTeam2);

    void showClubsInLeague();

    void showClubInfo(String clubName);

    void displayTournamentTable();

}
