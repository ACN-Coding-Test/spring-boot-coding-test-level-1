package com.codejam.demo.repo;

import com.codejam.demo.pojo.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue,Integer> {
}
