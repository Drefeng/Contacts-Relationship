package no.experis.academy.SqlHelper;

import no.experis.academy.Interfaces.CRUD;
import no.experis.academy.Model.Family;

import java.sql.*;
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
                personId = rs.getInt("person_id");
                relativeId = rs.getInt("relative_id");
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

        Family family = null;

        try(Connection conn = PostgresConnection.connect()){
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM  Family WHERE id=" + id + ";");


            int p_id = 0;
            int r_id = 0;
            int rel_id = 0;

            while(rs.next()){
                p_id = rs.getInt("p_id");
                r_id  = rs.getInt("r_id");
                rel_id  = rs.getInt("rel_id");

                family = new Family(id, p_id, r_id, rel_id);

            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return family;
    }

    @Override
    public void add(Family family) {

        String insertQuery = "INSERT INTO family(person_id, relative_id, relation_id) VALUES(?, ?, ?);";

        try( Connection conn = PostgresConnection.connect()){
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, family.getP_id());
            pstmt.setInt(2, family.getRel_id());
            pstmt.setInt(3, family.getRelation_id());
            pstmt.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Family family) {
        Connection conn = PostgresConnection.connect();
        try{
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE FAMILY SET person_id="
                    + family.getP_id() + ", " + "relative_id=" + family.getRel_id() + ", "+ " relation_id=" + family.getRelation_id());

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Family delete(Family item) {
        return null;
    }


    public Iterable<Family> getByPersonId(int p_id){
        List<Family> families = new ArrayList<>();

        String query = "SELECT * FROM family;";

        try (Connection conn = PostgresConnection.connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            int id, r_id, rel_id;


            while (rs.next()) {
                id = rs.getInt("id");
                rel_id = rs.getInt("relation_id");

                if (p_id == rs.getInt("person_id")) {
                    r_id = rs.getInt("relative_id");
                    families.add(new Family(id, p_id, r_id, rel_id));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return families;
    }


}
