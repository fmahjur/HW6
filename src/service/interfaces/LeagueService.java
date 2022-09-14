package service.interfaces;

public interface LeagueService {
    void addClub(String clubName);

    boolean deleteClub(String clubName);

    void addPlay(String club1, String club2);

    void showClubInfo(String clubName);

    void displayTournamentTable();

}
