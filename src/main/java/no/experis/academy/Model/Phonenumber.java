package no.experis.academy.Model;

public class Phonenumber {
    private int id;
    private String home;
    private String mobile;
    private String work;
    private int phoneRef;


    public Phonenumber(int id, String home, String mobile, String work, int phoneRef) {
        this.id = id;
        this.phoneRef = phoneRef;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
    }

    public Phonenumber(int id, String home, String mobile, String work) {
        this.id = id;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
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



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {return id;}

    public int getPhoneRef() {
        return phoneRef;
    }

    public void setPhoneRef(int phoneRef) {
        this.phoneRef = phoneRef;
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


    public String toString(){
        return getId() + " " + getHome() + " " + getMobile() + " " + getWork() + " " + getPhoneRef();
    }
}
