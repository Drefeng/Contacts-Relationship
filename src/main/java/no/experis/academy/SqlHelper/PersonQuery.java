package no.experis.academy.SqlHelper;

import no.experis.academy.Model.CreateTable;
import no.experis.academy.Model.Person;

import java.sql.*;

public class PersonQuery {
    private PersonQuery() {

    }

    public static Person getPerson(int id) {
        Connection conn = PostgresConnection.connect();

        try {
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet rs = dbm.getTables(null, null, "person", null);

            if (rs.next()) {
                System.out.println("table exists");
                conn.setAutoCommit(false);

                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM person WHERE _id=" + id);
                while (resultSet.next()) {
                    String firstName = resultSet.getString("firstname");
                    String lastName = resultSet.getString("lastname");
                    Date date = resultSet.getDate("birthday");

                    System.out.printf("%s %s %s", firstName, lastName, date);
                }

                PostgresConnection.disconnect();

            } else {
                System.out.println("table doesn't exists");

                PostgresConnection.disconnect();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public static Person getPerson(String firstName) {
        return null;
    }
}
