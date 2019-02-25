package no.experis.academy.Model;

public class Address {
    public String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Address(String currentAddress){
        this.address = currentAddress;
    }
}
