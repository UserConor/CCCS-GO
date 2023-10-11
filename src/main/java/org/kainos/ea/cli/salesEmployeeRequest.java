package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CustomerRequest {
    private int CustomerID;
    private String Name;
    private String Address;
    private int Phone;

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    @JsonCreator
    public CustomerRequest(
            @JsonProperty("CustomerID") int customerID,
            @JsonProperty("Name") String name,
            @JsonProperty("Address") String address,
            @JsonProperty("Phone") int Phone) {
        this.CustomerID = customerID;
        this.Name = name;
        this.Address = address;
        this.Phone = Phone;
    }
}
