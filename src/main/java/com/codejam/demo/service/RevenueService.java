package com.codejam.demo.service;

import com.codejam.demo.pojo.Revenue;

public interface RevenueService {
	
    Revenue findById(Integer id);

    Revenue saveRevenue(Revenue revenue);

    Revenue updateRevenue(Revenue revenue);

    void deleteRevenue(Integer id);


}