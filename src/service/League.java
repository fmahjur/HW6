package service;

public interface League {
    public void addClub();
    public boolean deleteClub(String name);
    public void addPlay(String club1, String club2);
    public void showClubInfo(String name);
    public void displayTournamentTable();

}
