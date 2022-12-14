package com.example.nestdigital.controller;

import com.example.nestdigital.dao.LMSDao;
import com.example.nestdigital.dao.TotalLeaveCountDao;
import com.example.nestdigital.model.LMSModel;
import com.example.nestdigital.model.TotalLeaveCountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class LMSController {
    @Autowired
    private LMSDao lmsDao;
    @Autowired
    private TotalLeaveCountDao totalLeaveCountDao;



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeaveForm",consumes = "application/json",produces = "application/json")
    HashMap<String,String> AddLeave(@RequestBody LMSModel lmsModel){
        HashMap<String,String> map =new HashMap<>();
        lmsDao.save(lmsModel);
        map.put("status","success");
        return  map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leaveHandle",consumes = "application/json",produces = "application/json")
    List<LMSModel> CountLeaveDays(@RequestBody LMSModel lmsModel) throws ParseException {
        List<LMSModel> result=lmsDao.CountLeave(String.valueOf(lmsModel.getEmpid()));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        Date date1 = null;
        Date date2=null;
        String startDate=result.get(0).getFromDate();
        String enddate=result.get(0).getToDate();
        date1=simpleDateFormat.parse(startDate);
        date2=simpleDateFormat.parse(enddate);
        long getDiff = date2.getTime() - date1.getTime();
        long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
        System.out.println(result.get(0).getCasualLeave());

        return (List<LMSModel>) result;
    }
}
