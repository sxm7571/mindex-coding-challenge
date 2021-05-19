package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DataBootstrap {
    private static final String DATASTORE_LOCATION = "/static/employee_database.json";
//    private static final String DATASTORE_LOCATION2 = "/static/compensation_database.json"; //1

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private CompensationRepository compensationRepository; //2


    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        InputStream inputStream = this.getClass().getResourceAsStream(DATASTORE_LOCATION);
//        InputStream inputStream2 = this.getClass().getResourceAsStream(DATASTORE_LOCATION2); //3

        Employee[] employees = null;
//        Compensation[] compensations = null; //4

        try {
            employees = objectMapper.readValue(inputStream, Employee[].class);
//            compensations = objectMapper.readValue(inputStream2, Compensation[].class); //5
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Employee employee : employees) {
            employeeRepository.insert(employee);
        }
//
//        //6
//        for (Compensation compensation : compensations) {
//            compensationRepository.insert(compensation);
//        }
//

    }
}
