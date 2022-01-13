package com.codejam.demo.repository;

import com.codejam.demo.model.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Integer> {
}
