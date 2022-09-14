package ir.maktab.repository;

import ir.maktab.model.entity.VolleyballClub;

import java.sql.*;

import static ir.maktab.repository.DBConnection.getConnection;

public class VolleyballClubRepository {
    private static VolleyballClubRepository instance = new VolleyballClubRepository();

    private VolleyballClubRepository() {
    }

    public static VolleyballClubRepository getInstance() {
        return instance;
    }

    public void insertVolleyballClub(VolleyballClub volleyballClub) throws Exception {
        String insertQuery = "INSERT INTO volleyball_club (club_name, number_of_wins, number_of_defeats," +
                " number_of_rounds_win, number_of_rounds_defeat, number_of_points, number_of_played)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertQuery);
        prepareStatement.setString(1, volleyballClub.getNameOfTheClub());
        prepareStatement.setInt(2, volleyballClub.getNumberOFWins());
        prepareStatement.setInt(3, volleyballClub.getNumberOfDefeats());
        prepareStatement.setInt(4, volleyballClub.getNumberOfRoundsWin());
        prepareStatement.setInt(5, volleyballClub.getNumberOfRoundsDefeat());
        prepareStatement.setInt(6, volleyballClub.getNumberOfPoints());
        prepareStatement.setInt(7, volleyballClub.getNumberOfPlayed());
        prepareStatement.executeUpdate();
        getConnection().close();
    }

    public void deleteVolleyballClub(String clubName) throws SQLException {
        String deleteQuery = "DELETE FROM volleyball_club WHERE club_name =  \'" + clubName + "\'";
        Statement statement = getConnection().createStatement();
        statement.executeUpdate(deleteQuery);
        getConnection().close();
    }

    public VolleyballClub selectVolleyballClub(String clubName) throws SQLException {
        String selectQuery = "SELECT * FROM football_club WHERE club_name =  \'" + clubName + "\'";
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        VolleyballClub volleyballClub = null;
        if (resultSet.next()) {
            volleyballClub = new VolleyballClub(resultSet.getString("club_name"),
                    resultSet.getInt("number_of_wins"),
                    resultSet.getInt("number_of_defeats"),
                    resultSet.getInt("number_of_rounds_win"),
                    resultSet.getInt("number_of_rounds_defeat"),
                    resultSet.getInt("number_of_points"),
                    resultSet.getInt("number_of_played"));
        }
        getConnection().close();
        return volleyballClub;
    }
}
