package com.example.demo.repository;

import com.example.demo.entity.CommissionEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommissionRepository extends CrudRepository <CommissionEntity, Long> {
}
