package no.experis.academy.SqlHelper;

import no.experis.academy.Interfaces.CRUD;
import no.experis.academy.Model.Family;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FamilyQuery implements CRUD<Family> {


    @Override
    public Iterable getAll() {
        List<Family> families = null;

        try (Connection conn = PostgresConnection.connect()) {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM family;");

            families = new ArrayList<>();

            int id = 0;
            int personId = 0;
            int relativeId = 0;
            int relationId = 0;

            while (rs.next()) {
                id = rs.getInt("id");
                personId = rs.getInt("p_id");
                relativeId = rs.getInt("rel_id");
                relationId = rs.getInt("relation_id");

                families.add(new Family(id, personId,relativeId, relationId));

                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return families;
    }

    @Override
    public Family getById(int id) {

        try(Connection conn = PostgresConnection.connect()){
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM  Family WHERE id=" + id + ";");


            int p_id = 0;
            int r_id = 0;
            int rel_id = 0;

            while(rs.next()){
                p_id = rs.getInt("p_id");
                r_id = rs.getInt("r_id");
                rel_id = rs.getInt("rel_id");

                System.out.printf("%s %s %s ", p_id, r_id, rel_id);


            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Family family) {
        Connection conn = PostgresConnection.connect();

        try{
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Family(p_id, r_id, rel_id)" +
                    " VALUES(" + family.getP_id()+ ", " + family.getRel_id() + ", " + family.getRelation_id() + ";");

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

    @Override
    public void update(Family family) {
        Connection conn = PostgresConnection.connect();

        try{
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE FAMILY SET p_id="
                    + family.getP_id() + ", " + "r_id=" + family.getRel_id() + ", "+ " rel_id=" + family.getRelation_id());

        }catch(SQLException e){

        }

    }

    @Override
    public Family delete(Family item) {
        return null;
    }

    public Iterable<Family> getByPersonId(){
        return null;
    }


}
