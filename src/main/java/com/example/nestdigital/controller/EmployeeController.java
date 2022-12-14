package com.example.nestdigital.controller;
import com.example.nestdigital.dao.EmployeeDao;
import com.example.nestdigital.dao.TotalLeaveCountDao;
import com.example.nestdigital.model.EmployeeModel;
import com.example.nestdigital.model.LMSModel;
import com.example.nestdigital.model.TotalLeaveCountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private TotalLeaveCountDao totalLeaveCountDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addEmployee",consumes = "application/json",produces = "application/json")
    HashMap<String,String> AddEmployee(@RequestBody EmployeeModel employeeModel){
        HashMap<String,String> map =new HashMap<>();
         LMSModel lmsModel = new LMSModel();
         TotalLeaveCountModel totalLeaveCountModel =new TotalLeaveCountModel();
        employeeDao.save(employeeModel);
        totalLeaveCountModel.setEmpid(employeeModel.getEmpid());
        totalLeaveCountModel.setCasualLeave(20);
        totalLeaveCountModel.setSickLeave(7);
        totalLeaveCountModel.setSplLeave(3);
        totalLeaveCountDao.save(totalLeaveCountModel);
        map.put("status","success");
        return  map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewEmployees")
    public List<EmployeeModel> ViewEmployee()
    {
        return (List<EmployeeModel>) employeeDao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchEmployee",produces = "application/json",consumes = "application/json")
    public List<EmployeeModel> SearchEmployee(@RequestBody EmployeeModel employeeModel)
    {
        String ecode=String.valueOf(employeeModel.getEmpid());

        return (List<EmployeeModel>) employeeDao.FindEmployee(employeeModel.getEmpid());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteEmployee",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> DeleteEmployee(@RequestBody EmployeeModel employeeModel)
    {
        String eid=String.valueOf(employeeModel.getEmpid());

        employeeDao.DeleteEmployee(employeeModel.getEmpid());

        HashMap<String,String> map=new HashMap<>();

        map.put("status","employee deleted");

        return map;
    }
}
