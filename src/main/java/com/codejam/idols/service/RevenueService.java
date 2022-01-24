package com.codejam.idols.service;

import java.util.List;

import com.codejam.idols.entity.Revenue;

public interface RevenueService {

	public Integer saveRevenue(Revenue revenue);

	public List<Revenue> getAllUsersRevenue();

	public Revenue getUserRevenueById(Integer id);

	public void removeUserRevenueById(Integer id);

	public void updateUserRevenue(Revenue revenue);

}
