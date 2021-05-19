package com.mindex.challenge.service.impl;

import com.mindex.challenge.controller.ReportingStructureController;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceUnitTest {

    @Autowired
    private CompensationServiceImpl compensationService;

    @Test
    public void testCompensation(){
        Compensation mockCompensation = new Compensation();
        mockCompensation.setEmployeeID("16a596ae-edd3-4847-99fe-c4518e82c86f");
        mockCompensation.setSalary("100000.00");
        mockCompensation.setEffectiveDate("5-18-2021");

        Compensation testCreateCompensation = compensationService.create(mockCompensation);

        Compensation testReadCompensation = compensationService.read(mockCompensation.getEmployeeID());

        assertEquals(testReadCompensation.getEmployeeID(), "16a596ae-edd3-4847-99fe-c4518e82c86f");

        assertEquals(testReadCompensation.getSalary(), "100000.00");

        assertEquals(testReadCompensation.getEffectiveDate(), "5-18-2021");
    }
}
