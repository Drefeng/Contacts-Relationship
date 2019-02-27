package no.experis.academy.SqlHelper;

import java.sql.*;
import no.experis.academy.Interfaces.CRUD;
import no.experis.academy.Model.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonQuery implements CRUD<Person> {
    public PersonQuery() {

    }

    @Override
    public Iterable<Person> getAll() {
        List<Person> persons = null;

        try (Connection conn = PostgresConnection.getConnection()) {
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
        Person person = null;

        try (Connection conn = PostgresConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM person WHERE id='" + id + "';";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                LocalDate birthday = LocalDate.parse(rs.getDate("birthday").toString());
                person = new Person(id, firstName, lastName, birthday);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public Iterable<Person> getByName(String name) {
        List<Person> persons = new ArrayList<>();

        String query = "SELECT * FROM person;";

        try (Connection conn = PostgresConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            String firstName, lastName, fullName;
            int id;
            LocalDate birthday;

            while (rs.next()) {
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                fullName = firstName + " " + lastName;
                if (fullName.toLowerCase().contains(name.toLowerCase())) {
                    id = rs.getInt("id");
                    birthday = LocalDate.parse(rs.getDate("birthday").toString());
                    persons.add(new Person(id, firstName, lastName, birthday));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public void add(Person person) {
        String insertQuery = "INSERT INTO person(firstname, lastname, birthday) VALUES(?, ?, ?);";

        try (Connection conn = PostgresConnection.getConnection()) {

            for (Person p : getByName(person.getFirstName() + " " + person.getLastName())) {
                if (person.equals(p)) {
                    System.out.println("Person already exist.");
                    return;
                }
            }

            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, person.getFirstName());
            pstmt.setString(2, person.getLastName());
            pstmt.setDate(3, Date.valueOf(person.getBirthday().toString()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Person person) {

    }

    public void updateById(int id, Person person) {
        Connection conn = PostgresConnection.getConnection();
        String updateQuery = "UPDATE person SET firstname=?, lastname=?, birthday=? WHERE id=" + id;
        try {
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, person.getFirstName());
            pstmt.setString(2, person.getLastName());
            pstmt.setDate(3, Date.valueOf(person.getBirthday().toString()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person delete(Person item) {

        return null;
    }

    public boolean deleteById(int id) {
        Connection conn = PostgresConnection.getConnection();

        String deleteQuery = "DELETE FROM person WHERE id=" + id;
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(deleteQuery);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
