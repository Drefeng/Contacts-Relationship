package no.experis.academy.SqlHelper;

import no.experis.academy.Interfaces.CRUD;
import no.experis.academy.Model.Email;
import no.experis.academy.Model.Phonenumber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailQuery implements CRUD<Email> {

    @Override
    public Iterable<Email> getAll() {

        List<Email> emails = null;

        try (Connection conn = PostgresConnection.connect()) {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM email");

            emails = new ArrayList<>();

            int id = 0;
            String pesonal;
            String work;

            while (rs.next()) {
                id = rs.getInt("id");
                pesonal = rs.getString("personal");
                work = rs.getString("work");
                emails.add(new Email(pesonal, work));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emails;
    }

    @Override
    public Email getById(int id) {
        Email email = null;

        try (Connection conn = PostgresConnection.connect()) {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM email WHERE id='" + id + "';";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String personal = rs.getString("home");
                String work = rs.getString("mobile");

                email = new Email(personal, work);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    @Override
    public void add(Email email) {
        String insertQuery = "INSERT INTO email(personal, work) VALUES(?, ?);";

        try (Connection conn = PostgresConnection.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, email.getPersonal());
            pstmt.setString(2, email.getWork());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCustom(Email email, int id) {
        String insertQuery = "INSERT INTO email(personal, work, id) VALUES(?, ?, ?);";

        try (Connection conn = PostgresConnection.connect()) {

            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, email.getPersonal());
            pstmt.setString(2, email.getWork());
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Email item) {

    }

    public void updateEmailById(int id, Email email) {
        Connection conn = PostgresConnection.connect();
        String updateQuery = "UPDATE email SET personal=?, work=? WHERE id=" + id;
        try {
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, email.getPersonal());
            pstmt.setString(2, email.getWork());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Email delete(Email item) {
        return null;
    }

    public void deleteById(int id) {
        Connection conn  = PostgresConnection.connect();
        String deleteQuery = "DELETE FROM email WHERE id=" + id;
        try{
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
