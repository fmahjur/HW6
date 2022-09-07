package repository;

import model.FootballClub;
import model.VolleyballClub;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VolleyballClubRepository {
    private final static String URL = "jdbc:postgresql://127.0.0.1:5432/league";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "Rm@38936";

    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void insertFootballClub(VolleyballClub volleyballClub) throws SQLException, Exception {
        String insertQuery = "INSERT INTO volleyball_club (club_name, number_of_wins, number_of_defeats," +
                " number_of_rounds_win, number_of_rounds_defeat, number_of_points, number_of_played)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement prepareStatement = connect().prepareStatement(insertQuery);
        prepareStatement.setString(1, volleyballClub.getNameOfTheClub());
        prepareStatement.setInt(2, volleyballClub.getNumberOFWins());
        prepareStatement.setInt(3, volleyballClub.getNumberOfDefeats());
        prepareStatement.setInt(4, volleyballClub.getNumberOfRoundsWin());
        prepareStatement.setInt(5, volleyballClub.getNumberOfRoundsDefeat());
        prepareStatement.setInt(6, volleyballClub.getNumberOfPoints());
        prepareStatement.setInt(7, volleyballClub.getNumberOfPlayed());
        prepareStatement.executeUpdate();
    }

    public void deleteVolleyballClub(String name) throws SQLException {
        String deleteQuery = "DELETE FROM volleyball_club WHERE club_name = clubName";
        Statement statement = (Statement) connect().createStatement();
        statement.executeUpdate(deleteQuery);
    }

    public List<VolleyballClub> selectVolleyballClub(String clubName) throws SQLException {
        ArrayList<VolleyballClub> clubs = new ArrayList<VolleyballClub>();
        String selectQuery = "SELECT * FROM football_club WHERE club_name = clubName";
        Statement statement = (Statement) connect().createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        if (resultSet.next())
            while (resultSet.next()) {
                VolleyballClub volleyballClub = new VolleyballClub(resultSet.getString("club_name"),
                        resultSet.getInt("number_of_wins"),
                        resultSet.getInt("number_of_defeats"),
                        resultSet.getInt("number_of_rounds_win"),
                        resultSet.getInt("number_of_rounds_defeat"),
                        resultSet.getInt("number_of_points"),
                        resultSet.getInt("number_of_played"));
                clubs.add(volleyballClub);
            }
        return clubs;
    }
}
