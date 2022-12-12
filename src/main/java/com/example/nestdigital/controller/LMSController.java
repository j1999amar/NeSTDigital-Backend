package com.example.nestdigital.controller;

import com.example.nestdigital.dao.LMSDao;
import com.example.nestdigital.model.LMSModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LMSController {
    @Autowired
    private LMSDao lmsDao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeaveForm",consumes = "application/json",produces = "application/json")
    HashMap<String,String> AddLeave(@RequestBody LMSModel lmsModel){
        HashMap<String,String> map =new HashMap<>();
        lmsDao.save(lmsModel);
        map.put("status","success");
        return  map;

    }
}
