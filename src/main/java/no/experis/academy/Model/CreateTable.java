package no.experis.academy.Model;

import no.experis.academy.SqlHelper.PostgresConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

    public static void createPersonTable(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE person"
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
        System.out.println("Person table created successfully");
    }

    public static void createPhoneTable(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE phone"
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

    public static void createEmailTable(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE email"
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

    public static void createAddressTable(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE address"
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

    public static void createRelationShip(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE relationship"
                    + "(id SERIAL PRIMARY KEY NOT NULL,"
                    + "role VARCHAR(100));";

            stmt.executeUpdate(sql);
            stmt.close();
            connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Relationship table created successfully");
    }

    public static void createFamilyTable(){
        Connection connect = null;
        Statement stmt = null;
        try{
            connect = PostgresConnection.connect();
            stmt = connect.createStatement();
            String sql = "CREATE TABLE family"
                    + "(id SERIAL PRIMARY KEY NOT NULL,"
                    + "person_id INT REFERENCES person (id) NOT NULL,"+
                    " relative_id INT REFERENCES person (id) NOT NULL,"
                    + "relation_id INT REFERENCES relationship (id));";

            stmt.executeUpdate(sql);
            stmt.close();
            connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Family table created successfully");
    }

}
