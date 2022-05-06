package com.codejam.demo.serviceImplementation;

import com.codejam.demo.dto.ScheduleDto;
import com.codejam.demo.enums.RecordStatus;
import com.codejam.demo.exception.ResourceNotFoundException;
import com.codejam.demo.helper.GetListHelper;
import com.codejam.demo.model.Schedule;
import com.codejam.demo.repository.ScheduleRepository;
import com.codejam.demo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImplementation implements ScheduleService {

    private final ScheduleRepository repository;

    private final EntityManager em;

    @Override
    @Transactional
    public Schedule save(ScheduleDto scheduleDto) {
        Schedule schedule = scheduleDto.to();
        //helper.getSaveData(schedule);
        Schedule savedSchedule = repository.save(schedule);
        return savedSchedule;
    }
    @Override
    @Transactional
    public Schedule update(ScheduleDto dto, RecordStatus status){
        Schedule schedule = repository.findById(dto.getSchedule_id()).orElseThrow(() -> new ResourceNotFoundException("id: " + dto.getSchedule_id()));
        dto.update(dto, schedule);
        //helper.getUpdatedData(schedule, status);
        Schedule updatedSchedule = repository.save(schedule);
        return updatedSchedule;
    }

    @Override
    public Optional<Schedule> findById(int id) {
        Optional<Schedule> schedule= repository.findById(id);
        return schedule;
    }

   @Override
    public Optional<Schedule> findByVenue(String venue) {
        Optional<Schedule> schedule = repository.findByVenue(venue);
        return schedule;
    }


    @Override
    public List<Schedule> findAll(String[] sortable, String sortBy, Map<String, Object> filterMap) {
        return new GetListHelper<Schedule>(em, Schedule.class).findAll(sortable, sortBy);
    }

    @Override
    public Map<String, Object> getList(String venue, Integer page, Integer size, String sortBy) {
        GetListHelper<Schedule> helper = new GetListHelper<>(em, Schedule.class);

        return helper.getList(repository.searchSchedule(venue,
                helper.getPageable(sortBy, page, size)), page, size);
    }


    @Override
    @Transactional
    public void updateRecordStatus(Integer schedule_id, RecordStatus status) {
        Schedule schedule = repository.findById(schedule_id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule Id: " + schedule_id));
      //  helper.getUpdatedData(schedule, status);
        repository.save(schedule);
    }


}
