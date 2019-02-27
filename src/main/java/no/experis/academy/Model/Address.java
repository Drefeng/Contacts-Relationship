package no.experis.academy.Model;

public class Address {

    private int id;
    private int refId;
    private String currentAddress;
    private String workAddress;

    public Address(int id, int refId, String currentAddress, String workAddress) {
        this.id = id;
        this.refId = refId;
        this.currentAddress = currentAddress;
        this.workAddress = workAddress;
    }

    public Address(int refId, String currentAddress, String workAddress) {
        this.refId = refId;
        this.currentAddress = currentAddress;
        this.workAddress = workAddress;
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

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }
}
