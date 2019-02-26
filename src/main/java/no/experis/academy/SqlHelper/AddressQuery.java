package no.experis.academy.SqlHelper;

import no.experis.academy.Interfaces.CRUD;
import no.experis.academy.Model.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressQuery implements CRUD<Address> {
    public AddressQuery() {

    }

    @Override
    public Iterable<Address> getAll() {
        List<Address> addresses = null;

        try (Connection conn = PostgresConnection.connect()) {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM address");

            addresses = new ArrayList<>();

            int id = 0;
            String currentAddress;
            String workAddress;

            while (rs.next()) {
                id = rs.getInt("id");
                currentAddress = rs.getString("currentAddress");
                workAddress = rs.getString("workAddress");
                addresses.add(new Address(id, currentAddress, workAddress));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public Address getById(int id) {
        return null;
    }

    @Override
    public void add(Address item) {

    }

    @Override
    public void update(Address item) {

    }

    @Override
    public Address delete(Address item) {
        return null;
    }

    public static Address getAddress(int id) {
        Connection conn = PostgresConnection.connect();

        try {
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet rs = dbm.getTables(null, null, "address", null);

            if (rs.next()) {
                System.out.println("table exists");
                conn.setAutoCommit(false);

                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM address WHERE _id=" + id);
                while (resultSet.next()) {
                    String currentAddress = resultSet.getString("currentAddress");
                    String workAddress = resultSet.getString("workAddress");

                    System.out.printf("%s %s %s", currentAddress, workAddress);
                }
            } else {
                System.out.println("table doesn't exists");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Address getAddress(String currentAddress) {
        return null;
    }

    public static void createAddress(Address address) {
        Connection conn = PostgresConnection.connect();

        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            System.out.println("INSERT INTO address(currentAddress, workAddress) VALUES('" + address.getCurrentAddress() + "', '" + address.getWorkAddress() + "');");
            stmt.executeUpdate("INSERT INTO address(currentAddress, workAddress) VALUES('" + address.getCurrentAddress() + "', '" + address.getWorkAddress() + "');");
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
