package repository;

import model.entity.FootballClub;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static repository.DBConnection.getConnection;

public class FootballClubRepository {
    private static FootballClubRepository instance = new FootballClubRepository();
    private FootballClubRepository(){}
    public static FootballClubRepository getInstance(){
        return instance;
    }

    public void insertFootballClub(FootballClub footballClub) throws Exception {
        String insertQuery = "INSERT INTO football_club (club_name, number_of_wins, number_of_defeats," +
                " number_of_draws, goals_received, goals_scored, number_of_points, number_of_played)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement prepareStatement = getConnection().prepareStatement(insertQuery);
        prepareStatement.setString(1, footballClub.getNameOfTheClub());
        prepareStatement.setInt(2, footballClub.getNumberOFWins());
        prepareStatement.setInt(3, footballClub.getNumberOfDefeats());
        prepareStatement.setInt(4, footballClub.getNumberOfDraws());
        prepareStatement.setInt(5, footballClub.getGoalsReceived());
        prepareStatement.setInt(6, footballClub.getGoalsScored());
        prepareStatement.setInt(7, footballClub.getNumberOfPoints());
        prepareStatement.setInt(8, footballClub.getNumberOfPlayed());
        prepareStatement.executeUpdate();
        getConnection().close();
    }

    public void deleteFootballClub(String clubName) throws SQLException {
        String deleteQuery = "DELETE FROM football_club WHERE club_name = clubName";
        Statement statement = getConnection().createStatement();
        statement.executeUpdate(deleteQuery);
        getConnection().close();
    }

    public List<FootballClub> selectFootballClub(String clubName) throws SQLException {
        ArrayList<FootballClub> clubs = new ArrayList<>();
        String selectQuery = "SELECT * FROM football_club WHERE club_name = clubName";
        Statement statement = getConnection().createStatement();
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
        getConnection().close();
        return clubs;
    }
}
