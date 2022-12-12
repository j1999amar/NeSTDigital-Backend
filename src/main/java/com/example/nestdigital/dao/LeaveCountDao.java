package com.example.nestdigital.dao;

import com.example.nestdigital.model.LeaveCountModel;
import org.springframework.data.repository.CrudRepository;

public interface LeaveCountDao extends CrudRepository<LeaveCountModel,Integer> {
}
