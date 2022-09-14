package ir.maktab.service;

import ir.maktab.model.entity.FootballClub;
import ir.maktab.repository.FootballClubRepository;
import ir.maktab.service.interfaces.ClubService;

import java.sql.SQLException;

public class FootballClubServiceImpl implements ClubService {
    FootballClubRepository footballClubRepository = FootballClubRepository.getInstance();

    public void addClub(FootballClub club) throws Exception {
        footballClubRepository.insertFootballClub(club);
    }

    @Override
    public void deleteClub(String nameOfTheClub) throws SQLException {
        footballClubRepository.deleteFootballClub(nameOfTheClub);
    }

    @Override
    public void showClubInfo(String nameOfTheClub) throws SQLException {
        FootballClub footballClub = footballClubRepository.selectFootballClub(nameOfTheClub);
        System.out.print(footballClub.toString());
        System.out.println();
    }
}
