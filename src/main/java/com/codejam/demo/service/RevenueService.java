package com.codejam.demo.service;

import com.codejam.demo.enums.RecordStatus;
import com.codejam.demo.model.Revenue;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RevenueService {

    Revenue save(Revenue revenue);

    Revenue update(Revenue revenue, RecordStatus status);

    Optional<Revenue> findById(int id);

    Optional<Revenue> findByMonthlyRate(String monthly_rate);

    List<Revenue> findAll(String[] sortable, String sortBy, Map<String, Object> filterMap);

    Map<String, Object> getList(String monthly_rate, Integer page, Integer size, String sortBy);

    //void updateRecordStatus(Integer schedule_id, RecordStatus status);
}
