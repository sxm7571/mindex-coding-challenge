package com.mindex.challenge.data;

import java.util.List;

public class ReportingStructure {

    private Employee employee;

    private int numberOfReports;

    public ReportingStructure(Employee employee, int numberOfReports) {
        this.employee = employee;
        this.numberOfReports = numberOfReports;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee e) {employee = e;}

    public int getNumberOfReports(){
        return numberOfReports;
    }

    public void setNumberOfReports(int n) {numberOfReports = n;}
}
