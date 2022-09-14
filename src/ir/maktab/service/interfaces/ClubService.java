package ir.maktab.service.interfaces;

import java.sql.SQLException;

public interface ClubService {
    void deleteClub(String nameOfTheClub) throws SQLException;
    void showClubInfo(String nameOfTheClub) throws SQLException;
}
