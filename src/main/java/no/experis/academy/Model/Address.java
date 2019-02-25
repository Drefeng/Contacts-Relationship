package no.experis.academy.Model;

public class Address {
    private String address;

    public Address(String currentAddress){
        this.address = currentAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
