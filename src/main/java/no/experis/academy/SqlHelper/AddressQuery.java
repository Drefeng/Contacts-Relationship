package no.experis.academy.SqlHelper;

import no.experis.academy.Interfaces.CRUD;
import no.experis.academy.Model.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressQuery implements CRUD<Address> {

    @Override
    public Iterable<Address> getAll() {
        List<Address> address = null;

        try (Connection conn = PostgresConnection.connect()) {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM address;");

            address = new ArrayList<>();

            int id = 0;
            int refId = 0;
            String currentAddress, workAddress;

            while (rs.next()) {
                id = rs.getInt("id");
                currentAddress = rs.getString("current");
                workAddress = rs.getString("work");
                refId = rs.getInt("address_ref");

                address.add(new Address(id, refId, currentAddress,workAddress ));

                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public Address getById(int id) {
        Address address = null;

        try(Connection conn = PostgresConnection.connect()){
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM  Address WHERE id=" + id + ";");

            int refId = 0;
            String currentAddress, workAddress;

            while(rs.next()){
                id = rs.getInt("id");
                refId  = rs.getInt("address_ref");
                currentAddress  = rs.getString("current");
                workAddress  = rs.getString("work");

                address = new Address(id, refId, currentAddress, workAddress);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void add(Address address) {

        String insertQuery = "INSERT INTO address(id, current, work, address_ref) VALUES(?, ?, ?, ?);";

        try( Connection conn = PostgresConnection.connect()){


            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, address.getId());
            pstmt.setString(2, address.getCurrentAddress());
            pstmt.setString(3, address.getCurrentAddress());
            pstmt.setInt(4, address.getRefId());
            pstmt.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Address item) {


    }

    @Override
    public Address delete(Address item) {
        return null;
    }


    public void updateById(int id, Address address) {
        Connection conn = PostgresConnection.connect();
        String updateQuery = "UPDATE address SET current=?, work=?,  WHERE id=" + id;
        try {
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, address.getCurrentAddress());
            pstmt.setString(2, address.getWorkAddress());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteById(int id) {
        Connection conn = PostgresConnection.connect();

        String deleteQuery = "DELETE FROM address WHERE id=" + id;
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
