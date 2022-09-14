package ir.maktab.service;

import ir.maktab.model.entity.VolleyballClub;
import ir.maktab.repository.VolleyballClubRepository;
import ir.maktab.service.interfaces.ClubService;

import java.sql.SQLException;

public class VolleyballClubServiceImpl implements ClubService {
    VolleyballClubRepository volleyballClubRepository = VolleyballClubRepository.getInstance();

    public void addClub(String nameOfTheClub, int numberOFWins, int numberOfDefeats,
                        int numberOfRoundsWin, int numberOfRoundsDefeat, int numberOfPoints, int numberOfPlayed) throws Exception {
        VolleyballClub club = new VolleyballClub(nameOfTheClub, numberOFWins, numberOfDefeats,
                numberOfRoundsWin, numberOfRoundsDefeat, numberOfPoints, numberOfPlayed);
        volleyballClubRepository.insertVolleyballClub(club);
    }

    @Override
    public void deleteClub(String nameOfTheClub) throws SQLException {
        volleyballClubRepository.deleteVolleyballClub(nameOfTheClub);
    }

    @Override
    public void showClubInfo(String nameOfTheClub) throws SQLException {
        VolleyballClub volleyballClub = volleyballClubRepository.selectVolleyballClub(nameOfTheClub);
        System.out.print(volleyballClub.toString());
        System.out.println();
    }
}
