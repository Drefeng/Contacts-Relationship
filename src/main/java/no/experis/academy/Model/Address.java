package no.experis.academy.Model;

public class Address {


    private String currentAddress;
    private String workAddress;

    public Address(String currentAddress, String workAddress){
        this.currentAddress = currentAddress;
        this.workAddress = workAddress;
    }

    public String getAddress() {
        return currentAddress;
    }

    public void setAddress(String address) {
        this.currentAddress = address;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }
}
