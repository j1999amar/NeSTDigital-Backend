package com.example.nestdigital.dao;

import com.example.nestdigital.model.SecurityModel;
import org.springframework.data.repository.CrudRepository;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {
}
