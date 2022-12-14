package com.example.nestdigital.dao;

import com.example.nestdigital.model.EmployeeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT * FROM `employee` WHERE `empid`=:empId",nativeQuery = true)
    List<EmployeeModel> FindEmployee(@Param("empId") int empId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employee` WHERE `empid`=:empId",nativeQuery = true)
    void DeleteEmployee(@Param("empId") int empId);

}
