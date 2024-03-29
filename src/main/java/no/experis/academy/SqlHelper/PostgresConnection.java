package no.experis.academy.SqlHelper;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    private static Connection conn = null;

    public static Connection connect() {
        String url = "jdbc:postgres://localhost:5432/local";

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getConnection(){

        try {
            URI dbUri = new URI("postgres://cuvjnnwlehuqix:85ba6fd1f3052e1f2fb64d3c2998b49bcdc1212c72433fa4b0e77a44bab2b517@ec2-46-137-170-51.eu-west-1.compute.amazonaws.com:5432/dd9bgbp44cm3ue");
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            System.out.println("Connected!");
            conn = DriverManager.getConnection(dbUrl, username, password);
        }catch(Exception e) {
            System.out.println("something went wrong");
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
