package com.codejam.idols.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codejam.idols.entity.Revenue;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Integer>{

}
