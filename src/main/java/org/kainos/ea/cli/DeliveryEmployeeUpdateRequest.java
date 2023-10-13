package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeUpdateRequest {
    private String Forename;
    private String Surname;
    private double Salary;
    private String BankNum;

    @JsonCreator
    public DeliveryEmployeeUpdateRequest(

            @JsonProperty("forename") String forename,
            @JsonProperty("surname") String surname,
            @JsonProperty("salary") Double salary,
            @JsonProperty("banknum") String bankNum) {

        this.Forename = forename;
        this.Surname = surname;
        this.Salary = salary;
        this.BankNum = bankNum;
    }

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
}
