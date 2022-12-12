package com.example.nestdigital.controller;

import com.example.nestdigital.dao.EmployeeDao;
import com.example.nestdigital.dao.SecurityDao;
import com.example.nestdigital.model.EmployeeModel;
import com.example.nestdigital.model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao securityDao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addSecurity",consumes = "application/json",produces = "application/json")
    HashMap<String,String> AddSecurity(@RequestBody SecurityModel securityModel){
        HashMap<String,String> map =new HashMap<>();
        securityDao.save(securityModel);
        map.put("status","success");
        return  map;

    }

}
