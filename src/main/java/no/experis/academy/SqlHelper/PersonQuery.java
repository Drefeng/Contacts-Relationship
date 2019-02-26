package no.experis.academy.SqlHelper;

import no.experis.academy.Interfaces.CRUD;
import no.experis.academy.Model.Person;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonQuery implements CRUD<Person> {
    public PersonQuery() {

    }

    @Override
    public Iterable<Person> getAll() {
        List<Person> persons = null;

        try (Connection conn = PostgresConnection.connect()) {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person");

            persons = new ArrayList<>();

            int id = 0;
            String firstName;
            String lastName;
            LocalDate birthday;

            while (rs.next()) {
                id = rs.getInt("id");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                birthday = LocalDate.parse(rs.getDate("birthday").toString());
                persons.add(new Person(id, firstName, lastName, birthday));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person getById(int id) {
        return null;
    }

    public Person getByName(String name) {
        return null;
    }

    @Override
    public void add(Person item) {

    }

    @Override
    public void update(Person item) {

    }

    @Override
    public Person delete(Person item) {
        return null;
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

    public static void createPerson(Person person) {
        Connection conn = PostgresConnection.connect();

        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            System.out.println("INSERT INTO person(firstname, lastname, birthday) VALUES('" + person.getFirstName() + "', '" + person.getLastName() + "', '" + person.getBirthday() + "');");
            stmt.executeUpdate("INSERT INTO persons(firstname, lastname, birthday) VALUES('" + person.getFirstName() + "', '" + person.getLastName() + "', '" + person.getBirthday() + "');");
            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
