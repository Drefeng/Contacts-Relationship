package no.experis.academy.Model;

public class Family {

    private int id;
    private int p_id;
    private int rel_id;
    private int relation_id;

    public Family(int id, int p_id, int rel_id, int relation_id) {
        this.id = id;
        this.p_id = p_id;
        this.rel_id = rel_id;
        this.relation_id = relation_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getRel_id() {
        return rel_id;
    }

    public void setRel_id(int rel_id) {
        this.rel_id = rel_id;
    }

    public int getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(int relation_id) {
        this.relation_id = relation_id;
    }
}
