package com.codejam.demo.dto;

import com.codejam.demo.model.Schedule;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


@Data
@NoArgsConstructor
public class ScheduleDto {

    private Integer schedule_id;

    private String venue;

    private String event_name;

    private String schedule_date_time;

    public static ScheduleDto from(Schedule schedule) {

        ScheduleDto scheduleDto = new ScheduleDto();

        scheduleDto.setSchedule_id(schedule.getId());
        scheduleDto.setEvent_name(schedule.getEvent_name());
        scheduleDto.setVenue(schedule.getVenue());
        scheduleDto.setSchedule_date_time(schedule.getDate_time());
        return scheduleDto;
    }

    public Schedule to() {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(this, schedule);
        return schedule;
    }

    public void update(ScheduleDto dto, Schedule schedule) {
        BeanUtils.copyProperties(dto, schedule);
    }

}


