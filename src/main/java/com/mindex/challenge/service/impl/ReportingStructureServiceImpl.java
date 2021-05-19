package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure reportingStructure(String id) {
        //recursion here
        LOG.debug("Reading employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        int numberOfReports = generateNumberOfReports(employee);

        ReportingStructure reportingStructure = new ReportingStructure(employee, numberOfReports);
        return reportingStructure;
    }

    private int generateNumberOfReports(Employee employee){
        int number = 0;
        if(employee.getDirectReports() != null){
            List<Employee> directReps = employee.getDirectReports();
            for(int i = 0; i < directReps.size(); i++){
                String nextReportID = directReps.get(i).getEmployeeId();
                Employee nextReport = employeeRepository.findByEmployeeId(nextReportID);
                        number += 1 + generateNumberOfReports(nextReport);
            }
        }
        return number;
    }
}
