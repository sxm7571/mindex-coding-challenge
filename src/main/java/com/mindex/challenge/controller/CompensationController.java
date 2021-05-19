package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

//    @GetMapping("/compensation/")
//    public Compensation create(@PathVariable Compensation compensation) {
//        LOG.debug("Received compensation create request for id [{}]", compensation);
//
//        return compensationService.create(compensation);
//    }

    @GetMapping("/compensation/{id}/{salary}/{effectiveDate}")
    public Compensation create(@PathVariable String id, String salary, String effectiveDate) {
        Compensation compensation = new Compensation();
        compensation.setEmployeeID(id);
        compensation.setSalary(salary);
        compensation.setEffectiveDate(effectiveDate);

        LOG.debug("Received compensation create request for id [{}]", compensation);

        return compensationService.create(compensation);
    }

    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received compensation read request for id [{}]", id);

        return compensationService.read(id);
    }
}
