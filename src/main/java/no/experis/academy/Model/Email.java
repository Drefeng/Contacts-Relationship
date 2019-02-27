package no.experis.academy.Model;

public class Email {
    private String personal;
    private String work;
    private int id;
    private int refId;

    public Email(int id, String personal, String work, int refId) {
        this.id = id;
        this. personal = personal;
        this.work = work;
        this.refId = id;
    }

    public Email(int id, String personal, String work){
        this.personal = personal;
        this.work = work;
        this.id = id;
    }

    public Email(String personal, String work){
        this.personal = personal;
        this.work = work;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRefId() {
        return refId;
    }

    public void setRefId(int refId) {
        this.refId = refId;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Email(String work){
        this.work = work;
    }

    public String toString(){
        return getPersonal() + " " + getWork() + " " + getRefId();
    }
}
