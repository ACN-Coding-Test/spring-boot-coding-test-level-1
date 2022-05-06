package com.codejam.demo.repository;

import com.codejam.demo.model.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    Optional<Schedule> findByVenue(String venue);

    @Query("SELECT q FROM Schedule q WHERE LOWER(q.venue) LIKE LOWER(CONCAT('%', :venue, '%'))")
    Page<Schedule> searchSchedule(String venue, Pageable pageable);
}
