package no.experis.academy.Model;

import no.experis.academy.Enums.Relation;

public class Relationship {
    private int id;
    private Relation relation;

    public Relationship(int id, Relation relation) {
        this.id = id;
        this.relation = relation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }
}
