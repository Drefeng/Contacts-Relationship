package no.experis.academy.SqlHelper;

import no.experis.academy.Model.Person;

import java.sql.Connection;

public class PersonQuery {
    private PersonQuery() {

    }

    public static Person getPerson(int id) {
        Connection conn = PostgresConnection.connect();


        return null;
    }

    public static Person getPerson(String firstName) {
        return null;
    }
}
