package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private final static String URL = "jdbc:postgresql://127.0.0.1:5432/league";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "Rm@38936";
    private Connection connection;

    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
