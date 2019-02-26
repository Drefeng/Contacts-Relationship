package no.experis.academy.SqlHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    private static Connection conn = null;

    public static Connection connect() {
        String url = "jdbc:postgresql://localhost:5432/local?user=postgres";

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void disconnect(){
            try {
                conn.close();
            }
            catch (Exception ex) {
                System.out.println("The following error has occured: " + ex.getMessage());
            }

    }
}
