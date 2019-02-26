package no.experis.academy.SqlHelper;

import no.experis.academy.Interfaces.CRUD;
import no.experis.academy.Model.Person;
import no.experis.academy.Model.Phonenumber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneQuery implements CRUD<Phonenumber> {

    @Override
    public Iterable<Phonenumber> getAll() {
        List<Phonenumber> phonenumber = null;

        try (Connection conn = PostgresConnection.connect()) {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM phone");

            phonenumber = new ArrayList<>();

            int id = 0;
            String home;
            String mobile;
            String work;

            while (rs.next()) {
                id = rs.getInt("id");
                home = rs.getString("home");
                mobile = rs.getString("mobile");
                work = rs.getString("work");
                phonenumber.add(new Phonenumber(id, home, mobile, work));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phonenumber;
    }

    @Override
    public Phonenumber getById(int id) {
        return null;
    }

    @Override
    public void add(Phonenumber phonenumber) {
        String insertQuery = "INSERT INTO phone(home, mobile, work) VALUES(?, ?, ?);";

        try (Connection conn = PostgresConnection.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, phonenumber.getHome());
            pstmt.setString(2, phonenumber.getMobile());
            pstmt.setString(3, phonenumber.getWork());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCustom(Phonenumber phonenumber, Person person) {
        String insertQuery = "INSERT INTO phone(home, mobile, work, id) VALUES(?, ?, ?, ?);";

        try (Connection conn = PostgresConnection.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, phonenumber.getHome());
            pstmt.setString(2, phonenumber.getMobile());
            pstmt.setString(3, phonenumber.getWork());
            pstmt.setInt(4, person.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Phonenumber item) {

    }

    @Override
    public Phonenumber delete(Phonenumber item) {
        return null;
    }
}
