package com.mindex.challenge.data;


public class Compensation {

    private String employeeID;

    private String salary;

    private String effectiveDate;

    /*
    public Compensation(String employeeID, String salary, String effectiveDate) {
        this.employeeID = employeeID;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    } */

    public Compensation() {

    }

    public String getEmployeeID(){
        return employeeID;
    }

    public void setEmployeeID(String employeeId) {
        this.employeeID = employeeId;
    }

    public String getSalary(){
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEffectiveDate(){
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
