package no.experis.academy.SqlHelper;

import no.experis.academy.Model.Person;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class PersonQuery {
    private PersonQuery() {

    }

    public static Person getPerson(int id) {
        Connection conn = PostgresConnection.connect();

        //DatabaseMetaData dbm = conn.getMetaData();

        return null;
    }

    public static Person getPerson(String firstName) {
        return null;
    }
}
