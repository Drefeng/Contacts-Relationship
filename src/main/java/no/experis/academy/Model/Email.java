package no.experis.academy.Model;

public class Email {
    private String personal;
    private String work;

    public Email(String personal, String work){
        this.personal = personal;
        this.work = work;
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
}
