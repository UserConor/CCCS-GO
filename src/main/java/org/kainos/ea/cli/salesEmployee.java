package org.kainos.ea.cli;

public class Customer implements Comparable<Customer>{
    private int customerID;
    private String name;
    private String Address;
    private int Phone;

    public Customer(int customerID, String name, String Address, int Phone) {
        this.customerID = customerID;
        this.name = name;
        this.Address = Address;
        this.Phone = Phone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    @Override
    public int compareTo(Customer customer) {
        return 0;
    }
}
