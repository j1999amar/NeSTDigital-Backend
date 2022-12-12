package com.example.nestdigital.controller;

import com.example.nestdigital.dao.LeaveCountDao;
import com.example.nestdigital.model.LMSModel;
import com.example.nestdigital.model.LeaveCountModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LeaveCountController {
    private LeaveCountDao leaveCountDao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leaveCount",consumes = "application/json",produces = "application/json")
    HashMap<String,String> LeaveCount(@RequestBody LeaveCountModel leaveCountModel){
        HashMap<String,String> map =new HashMap<>();
        leaveCountDao.save(leaveCountModel);
        map.put("status","success");
        return  map;

    }
}
