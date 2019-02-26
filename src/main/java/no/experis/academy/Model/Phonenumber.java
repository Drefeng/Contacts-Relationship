package no.experis.academy.Model;

public class Phonenumber {
    private String home;
    private String mobile;
    private String work;
    private int id;

    public Phonenumber(int id, String home, String mobile, String work) {
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.id = id;
    }

    public Phonenumber( String home, String mobile, String work) {
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.id = id;
    }

    public Phonenumber(String mobile, String work) {
        this.mobile = work;
        this.work = work;
    }

    public Phonenumber(String mobile){
        this.mobile = mobile;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public int getId() {return id;}

    public String toString(){
        return getId() + " " + getHome() + " " + getMobile() + " " + getWork();
    }
}
