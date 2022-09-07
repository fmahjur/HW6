package service;

public interface League {
    public void addClub(String clubName);
    public boolean deleteClub(String clubName);
    public void addPlay(String club1, String club2);
    public void showClubInfo(String clubName);
    public void displayTournamentTable();

}
