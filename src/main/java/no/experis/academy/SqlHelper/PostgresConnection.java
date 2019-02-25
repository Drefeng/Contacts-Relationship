package no.experis.academy.SqlHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    public static Connection connect() {
        Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/local?user=postgres";

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
