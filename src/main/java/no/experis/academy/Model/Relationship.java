package no.experis.academy.Model;

import no.experis.academy.Enums.Relation;

public class Relationship {
    private String id;
    private Relation relation;

    public Relationship(String id, Relation relation) {
        this.id = id;
        this.relation = relation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }
}
