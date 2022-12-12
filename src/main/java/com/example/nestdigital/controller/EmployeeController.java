package com.example.nestdigital.controller;

import com.example.nestdigital.dao.EmployeeDao;
import com.example.nestdigital.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addEmployee",consumes = "application/json",produces = "application/json")
    HashMap<String,String> AddEmployee(@RequestBody EmployeeModel employeeModel){
        HashMap<String,String> map =new HashMap<>();
        employeeDao.save(employeeModel);
        map.put("status","success");
        return  map;

    }}
