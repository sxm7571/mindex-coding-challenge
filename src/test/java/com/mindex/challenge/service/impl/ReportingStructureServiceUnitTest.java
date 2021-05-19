package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceUnitTest {

    @Autowired
    private ReportingStructureServiceImpl reportingStructureService;

    @Test
    public void testReportingStructureFor4() {
        /*
        This is a unit test checking to see that John Lennon is going to return the right number or reports.
         */
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("John");
        testEmployee.setLastName("Lennon");
        testEmployee.setDepartment("Engineering");
        testEmployee.setPosition("Development Manager");

        ReportingStructure mockedReportingStructure = new ReportingStructure(testEmployee, 4);

        ReportingStructure reportingStructureFromDatabase = reportingStructureService.reportingStructure
                ("16a596ae-edd3-4847-99fe-c4518e82c86f");

        int mockedNumber = mockedReportingStructure.getNumberOfReports();

        int fromDatabaseNumber = reportingStructureFromDatabase.getNumberOfReports();

        assertEquals(mockedNumber, fromDatabaseNumber);
    }

    @Test
    public void testReportingStructureFor2() {
        /*
        This is a unit test checking to see that John Lennon is going to return the right number or reports.
         */
        Employee testEmployee = new Employee();
        testEmployee.setFirstName("Ringo");
        testEmployee.setLastName("Starr");
        testEmployee.setDepartment("Engineering");
        testEmployee.setPosition("Developer V");

        ReportingStructure mockedReportingStructure = new ReportingStructure(testEmployee, 2);

        ReportingStructure reportingStructureFromDatabase = reportingStructureService.reportingStructure
                ("03aa1462-ffa9-4978-901b-7c001562cf6f");

        int mockedNumber = mockedReportingStructure.getNumberOfReports();

        int fromDatabaseNumber = reportingStructureFromDatabase.getNumberOfReports();

        assertEquals(mockedNumber, fromDatabaseNumber);
    }
}
