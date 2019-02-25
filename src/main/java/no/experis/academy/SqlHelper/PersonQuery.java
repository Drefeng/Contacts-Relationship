package no.experis.academy.SqlHelper;

import no.experis.academy.Model.Person;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            } else {
                System.out.println("table doesn't exists");
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
