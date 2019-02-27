package no.experis.academy.SqlHelper;

import no.experis.academy.Interfaces.CRUD;
import no.experis.academy.Model.Email;

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
            int refId = 0;
            String pesonal;
            String work;

            while (rs.next()) {
                id = rs.getInt("id");
                pesonal = rs.getString("personal");
                work = rs.getString("work");
                emails.add(new Email(id, pesonal, work, refId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emails;
    }

    public Iterable<Email> getAllByRefId(int refId) {

        List<Email> emails = null;

        try (Connection conn = PostgresConnection.connect()) {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM email WHERE emailRef='" + refId + "';");

            emails = new ArrayList<>();

            int id = 0;
            String pesonal;
            String work;
            int emailRefId = 0;

            while (rs.next()) {
                id = rs.getInt("id");
                pesonal = rs.getString("personal");
                work = rs.getString("work");
                emailRefId = rs.getInt("emailRef");
                emails.add(new Email(id, pesonal, work, emailRefId));
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
                int emailId = rs.getInt("id");
                String personal = rs.getString("home");
                String work = rs.getString("mobile");
                int refId = rs.getInt("emailRef");


                email = new Email(emailId,personal, work, refId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    public Email getByRefId(int refId) {
        Email email = null;

        try (Connection conn = PostgresConnection.connect()) {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM email WHERE emailRef='" + refId + "';";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int emailId = rs.getInt("id");
                String personal = rs.getString("home");
                String work = rs.getString("mobile");
                int emailRefId = rs.getInt("emailRef");

                email = new Email(emailId,personal, work, emailRefId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    @Override
    public void add(Email email) {
        String insertQuery = "INSERT INTO email(personal, work, emailRef) VALUES(?, ?, ?);";

        try (Connection conn = PostgresConnection.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, email.getPersonal());
            pstmt.setString(2, email.getWork());
            pstmt.setInt(3, email.getRefId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCustom(Email email, int refId) {

        try (Connection conn = PostgresConnection.connect()) {
            String insertQuery = "INSERT INTO email(personal, work, emailRef) VALUES(?, ?, ?);";

            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, email.getPersonal());
            pstmt.setString(2, email.getWork());
            pstmt.setInt(3, refId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Email item) {

    }

    public void updateEmailById(int id, Email email) {

        try (Connection conn = PostgresConnection.connect()){
            String updateQuery = "UPDATE email SET personal=?, work=? WHERE id=" + id;
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

        try(Connection conn  = PostgresConnection.connect()){
            String deleteQuery = "DELETE FROM email WHERE id=" + id;
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
