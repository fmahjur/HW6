package repository;

import model.FootballClub;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FootballClubRepository {
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


    public void insertFootballClub(FootballClub footballClub) throws SQLException, Exception {
        String insertQuery = "INSERT INTO football_club (club_name, number_of_wins, number_of_defeats," +
                " number_of_draws, goals_received, goals_scored, number_of_points, number_of_played)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement prepareStatement = connect().prepareStatement(insertQuery);
        prepareStatement.setString(1, footballClub.getNameOfTheClub());
        prepareStatement.setInt(2, footballClub.getNumberOFWins());
        prepareStatement.setInt(3, footballClub.getNumberOfDefeats());
        prepareStatement.setInt(4, footballClub.getNumberOfDraws());
        prepareStatement.setInt(5, footballClub.getGoalsReceived());
        prepareStatement.setInt(6, footballClub.getGoalsScored());
        prepareStatement.setInt(7, footballClub.getNumberOfPoints());
        prepareStatement.setInt(8, footballClub.getNumberOfPlayed());
        prepareStatement.executeUpdate();
    }

    public void deleteFootballClub(String name) throws SQLException {
        String deleteQuery = "DELETE FROM football_club WHERE club_name = clubName";
        Statement statement = (Statement) connect().createStatement();
        statement.executeUpdate(deleteQuery);
    }

    public List<FootballClub> selectFootballClub(String clubName) throws SQLException {
        ArrayList<FootballClub> clubs = new ArrayList<FootballClub>();
        String selectQuery = "SELECT * FROM football_club WHERE club_name = clubName";
        Statement statement = (Statement) connect().createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        if (resultSet.next())
            while (resultSet.next()) {
                FootballClub footballClub = new FootballClub(resultSet.getString("club_name"),
                        resultSet.getInt("number_of_wins"),
                        resultSet.getInt("number_of_defeats"),
                        resultSet.getInt("number_of_draws"),
                        resultSet.getInt("goals_received"),
                        resultSet.getInt("goals_scored"),
                        resultSet.getInt("number_of_points"),
                        resultSet.getInt("number_of_played"));
                clubs.add(footballClub);
            }
        return clubs;
    }
}
