package com.example.nestdigital.dao;

import com.example.nestdigital.model.LMSModel;
import com.example.nestdigital.model.TotalLeaveCountModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

public interface LMSDao extends CrudRepository<LMSModel,Integer> {
    @Query(value ="SELECT l.id ,l.apply_date, l.empid, l.from_date, l.leave_type, l.remarks, l.status, l.to_date,c.casual_leave FROM lms AS l JOIN leavecount AS c ON c.empid=l.empid WHERE l.empid= :empId ;", nativeQuery = true)
    List<LMSModel> CountLeave(@Param("empId") String empId);
//    @Query(value ="SELECT l.id ,l.apply_date, l.empid, l.from_date, l.leave_type, l.remarks, l.status, l.to_date FROM lms AS l JOIN leavecount AS c ON c.empid=l.empid WHERE l.empid= :empId ;", nativeQuery = true)
//    List<TotalLeaveCountModel> ab(@Param("empId") String empId);
}
