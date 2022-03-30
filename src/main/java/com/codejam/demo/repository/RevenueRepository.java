package com.codejam.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.codejam.demo.model.Revenue;

public interface RevenueRepository extends CrudRepository<Revenue, Integer> {
}
