package ir.maktab.service;

import ir.maktab.model.entity.VolleyballClub;
import ir.maktab.repository.VolleyballClubRepository;

public class VolleyballClubServiceImpl {
    VolleyballClubRepository volleyballClubRepository = VolleyballClubRepository.getInstance();

    public void addClub(String nameOfTheClub, int numberOFWins, int numberOfDefeats,
                        int numberOfRoundsWin, int numberOfRoundsDefeat, int numberOfPoints, int numberOfPlayed) throws Exception {
        VolleyballClub club = new VolleyballClub(nameOfTheClub, numberOFWins, numberOfDefeats,
                numberOfRoundsWin, numberOfRoundsDefeat, numberOfPoints, numberOfPlayed);
        volleyballClubRepository.insertVolleyballClub(club);
    }

}
