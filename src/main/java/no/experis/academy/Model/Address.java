package no.experis.academy.Model;

public class Address {

    private int id;
    private String currentAddress;
    private String workAddress;

    public Address(int id, String currentAddress, String workAddress){
        this.id = id;
        this.currentAddress = currentAddress;
        this.workAddress = workAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setAddress(String address) {
        this.currentAddress = address;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }
}
