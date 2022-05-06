package com.codejam.demo.service;

import com.codejam.demo.dto.ScheduleDto;
import com.codejam.demo.enums.RecordStatus;
import com.codejam.demo.model.Schedule;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ScheduleService {

    Schedule save(ScheduleDto scheduleDto);

    Schedule update(ScheduleDto scheduleDto, RecordStatus status);

    Optional<Schedule> findById(int id);

    Optional<Schedule> findByVenue(String venue);

    List<Schedule> findAll(String[] sortable, String sortBy, Map<String, Object> filterMap);

    Map<String, Object> getList(String venue, Integer page, Integer size, String sortBy);

    void updateRecordStatus(Integer schedule_id, RecordStatus status);

}
