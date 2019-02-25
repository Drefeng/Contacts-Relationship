package no.experis.academy.Model;

public class Phonenumber {
    private int home;
    private int mobile;
    private int work;

    public Phonenumber(int home, int mobile, int work) {
        this.home = home;
        this.mobile = mobile;
        this.work = work;
    }

    public Phonenumber(int mobile, int work) {
        this.mobile = work;
        this.work = work;
    }

    public Phonenumber(int mobile){
        this.mobile = mobile;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public void setWork(int work) {
        this.work = work;
    }

    public int getHome() {
        return home;
    }

    public int getMobile() {
        return mobile;
    }

    public int getWork() {
        return work;
    }
}
