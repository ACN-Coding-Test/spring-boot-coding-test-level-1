package com.codejam.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.codejam.demo.model.Schedule;


public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
}
