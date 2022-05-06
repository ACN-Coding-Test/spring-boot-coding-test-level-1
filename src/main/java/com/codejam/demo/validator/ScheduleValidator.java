package com.codejam.demo.validator;

import com.codejam.demo.model.Schedule;
import com.codejam.demo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

import static com.codejam.demo.constants.MessageConstants.SCHEDULE_EXIST;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Component
@RequiredArgsConstructor
public class ScheduleValidator implements Validator {

    private final ScheduleService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return Schedule.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors error) {
        Schedule schedule = (Schedule) target;

        if (isNotEmpty(schedule.getEvent_name())) {
            Optional<Schedule> schedule1 = service.findByVenue(schedule.getEvent_name());
            if (schedule1.isPresent()) {
                error.rejectValue("venue", null, SCHEDULE_EXIST);
            }
        }
    }

}
