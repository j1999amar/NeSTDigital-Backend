package com.example.nestdigital.dao;

import com.example.nestdigital.model.LMSModel;
import org.springframework.data.repository.CrudRepository;

public interface LMSDao extends CrudRepository<LMSModel,Integer> {
}
