package org.kainos.ea.cli;

public class DeliveryEmployee {
    private int DEmpID;
    private String Forename;
    private String Surname;
    private double Salary;
    private String BankNum;

    private String NINum;
    public DeliveryEmployee(int DEmpID, String forename, String surname, double salary, String bankNum, String NINum) {
        this.DEmpID = DEmpID;
        this.Forename = forename;
        this.Surname = surname;
        this.Salary = salary;
        this.BankNum = bankNum;
        this.NINum = NINum;
    }



    public int getDEmpID() {
        return DEmpID;
    }

    public void setDEmpID(int DEmpID) {
        this.DEmpID = DEmpID;
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

    public String getNINum() {
        return NINum;
    }

    public void setNINum(String NINum) {
        this.NINum = NINum;
    }



}
