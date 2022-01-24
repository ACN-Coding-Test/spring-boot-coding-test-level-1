package com.codejam.idols.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejam.idols.entity.Revenue;
import com.codejam.idols.entity.Schedule;
import com.codejam.idols.exceptions.RevenueNotFoundException;
import com.codejam.idols.exceptions.ScheduleNotFoundException;
import com.codejam.idols.repositpry.RevenueRepository;
import com.codejam.idols.service.RevenueService;

@Service
public class RevenueServiceImpl implements RevenueService {

	@Autowired
	private RevenueRepository revenueRepository;

	@Override
	public Integer saveRevenue(Revenue revenue) {
		revenue = revenueRepository.save(revenue);
		return revenue.getId();

	}

	@Override
	public List<Revenue> getAllUsersRevenue() {
		List<Revenue> revenueList = revenueRepository.findAll();
		return revenueList;
	}

	@Override
	public Revenue getUserRevenueById(Integer id) {
		return revenueRepository.findById(id).orElseThrow(
				() -> new RevenueNotFoundException("USER REVENUE WITH ID " + id + " NOT EXIST TO DISPLAY"));
	}

	@Override
	public void removeUserRevenueById(Integer id) {
		if (id == null || !revenueRepository.existsById(id)) {
			throw new RevenueNotFoundException("USER REVENUE " + id + " NOT EXIST TO REMOVE");
		} else {
			revenueRepository.delete(getUserRevenueById(id));
		}

	}

	@Override
	public void updateUserRevenue(Revenue revenue) {
		if (revenue == null || !revenueRepository.existsById(revenue.getId())) {
			throw new ScheduleNotFoundException("USER REVENUE " + revenue.getId() + " NOT EXIST TO UPDATE");
		} else {
			revenueRepository.save(revenue);
		}

	}

}
