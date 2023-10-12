package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {
    private String Forename;
    private String Surname;
    private double Salary;
    private String BankNum;
    private String NINum;


    public String getForename() {
        return Forename;
    }

    public void setForename(String forename) {
        Forename = forename;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getBankNum() {
        return BankNum;
    }

    public void setBankNum(String bankNum) {
        BankNum = bankNum;
    }

    public String getNINum() {
        return NINum;
    }

    public void setNINum(String NINum) {
        this.NINum = NINum;
    }

    @JsonCreator
    public DeliveryEmployeeRequest(
            @JsonProperty("forename") String forename,
            @JsonProperty("surname") String surname,
            @JsonProperty("salary") double salary,
            @JsonProperty("bankNum") String bankNum,
            @JsonProperty("NINum") String NINum) {
        this.Forename = forename;
        this.Surname = surname;
        this.Salary = salary;
        this.BankNum = bankNum;
        this.NINum = NINum;


    }
}