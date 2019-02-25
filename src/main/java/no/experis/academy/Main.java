package no.experis.academy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        connect();
    }

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
