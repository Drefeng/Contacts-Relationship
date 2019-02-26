package no.experis.academy.Model;

import no.experis.academy.SqlHelper.PostgresConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    private static void createPersonTable(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS person"
                        + "(id SERIAL PRIMARY KEY NOT NULL,"
                        + "firstname VARCHAR(100) NOT NULL,"
                        + "lastname VARCHAR(100) NOT NULL,"
                        + "birthday DATE NOT NULL);";

            stmt.executeUpdate(sql);
            stmt.close();
            connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Persons table created successfully");
    }

    private static void createPhoneTable(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS phone"
                    + "(id SERIAL PRIMARY KEY NOT NULL,"
                    + "home INT ,"
                    + "mobile INT,"
                    + "work INT,"
                    + "phoneref INT REFERENCES person (id));";

            stmt.executeUpdate(sql);
            stmt.close();
            connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Phone table created successfully");
    }

    private static void createEmailTable(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS email"
                    + "(id SERIAL PRIMARY KEY NOT NULL,"
                    + "personal VARCHAR(100),"
                    + "work VARCHAR(100),"
                    + "emailref INT REFERENCES person (id));";

            stmt.executeUpdate(sql);
            stmt.close();
            connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Email table created successfully");
    }

    private static void createAddressTable(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS address"
                    + "(id SERIAL PRIMARY KEY NOT NULL,"
                    + "current VARCHAR(100),"
                    + "work VARCHAR(100),"
                    + "address_ref INT REFERENCES person (id));";


            stmt.executeUpdate(sql);
            stmt.close();
            connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Address table created successfully");
    }

    private static void createRelationshipTable() throws Exception{
        Connection connect = PostgresConnection.connect();
        Statement stmt = connect.createStatement();

        String createTable = "CREATE TABLE IF NOT EXISTS relationship"
                + "(id SERIAL PRIMARY KEY NOT NULL,"
                + "role VARCHAR(100) UNIQUE);";
        PreparedStatement create = connect.prepareStatement(createTable);


        String updateTable = "INSERT INTO relationship"
                + "(role)"
                + "VALUES"
                + "('Father'), ('Mother'), ('Brother '), ('Sister')";
        PreparedStatement update = connect.prepareStatement(updateTable);

        boolean autoCommit = connect.getAutoCommit();
        try{
            connect.setAutoCommit(false);
            create.executeUpdate();
            update.executeUpdate();
            connect.commit();
            System.out.println("Relationship table created successfully");
        }catch(SQLException e){
            connect.rollback();
        }finally {
            connect.setAutoCommit(autoCommit);
        }

    }

    private static void createFamilyTable(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS family"
                    + "(id SERIAL PRIMARY KEY NOT NULL,"
                    + "person_id INT REFERENCES person (id) NOT NULL,"+
                    " relative_id INT REFERENCES person (id) NOT NULL,"
                    + "relation_id INT REFERENCES relationship (id));";

            stmt.executeUpdate(sql);
            stmt.close();
            connect.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Family table created successfully");
    }

    public static void createTables() {
        try{
            createPersonTable();
            createAddressTable();
            createPhoneTable();
            createEmailTable();
            createRelationshipTable();
            createFamilyTable();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
