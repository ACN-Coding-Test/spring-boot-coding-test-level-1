package com.codejam.demo.controller;

import com.codejam.demo.dto.ScheduleDto;
import com.codejam.demo.enums.RecordStatus;
import com.codejam.demo.exception.ResourceNotFoundException;
import com.codejam.demo.model.Schedule;
import com.codejam.demo.repository.ScheduleRepository;
import com.codejam.demo.service.ScheduleService;
import com.codejam.demo.utils.CommonDataHelper;
import com.codejam.demo.utils.PaginatedResponse;
import com.codejam.demo.validator.ScheduleValidator;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.codejam.demo.constants.MessageConstants.SCHEDULE_SAVE;
import static com.codejam.demo.constants.MessageConstants.SCHEDULE_UPDATE;
import static com.codejam.demo.utils.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/schedule/all")
    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    @GetMapping("/schedule/{id}")
    public Optional<Schedule> getSchedule(@PathVariable("id") Integer id) {
        return scheduleRepository.findById(id);
    }

    @PostMapping("/schedule/save")
    public Schedule saveSchedule(@RequestBody Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @PostMapping("/schedule/update")
    public Schedule updateSchedule(@RequestBody Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @GetMapping("/schedule/{schedule_id}/delete")
    public String deleteSchedule(@PathVariable("schedule_id") Integer id) {
        try {
            scheduleRepository.deleteById(id);
        } catch (Exception e) {
            return "Failed";
        }
        return "Successful";
    }

/*
    private final ScheduleRepository repository;

    private final ScheduleService service;

    private final CommonDataHelper helper;

    private final ScheduleValidator validator;

    private final String[] sortable = {"schedule_id", "venue"};

    @PostMapping("/schedule/save")
    public ResponseEntity<JSONObject> save(@Valid @RequestBody ScheduleDto scheduleDto, BindingResult bindingResult) {

        // ValidationUtils.invokeValidator(validator, scheduleDto, bindingResult);

//        if (bindingResult.hasErrors()) {
//            return badRequest().body(error(fieldError(bindingResult)).getJson());
//        }
        Schedule schedule = service.save(scheduleDto);
        return ok(success(ScheduleDto.from(schedule), SCHEDULE_SAVE).getJson());
    }

    @PutMapping("/schedule/update")
    public ResponseEntity<JSONObject> update(@Valid @RequestBody ScheduleDto scheduleDto, BindingResult bindingResult) {

//        if (bindingResult.hasErrors()) {
//            return badRequest().body(error(fieldError(bindingResult)).getJson());
//        }
        Schedule schedule = service.update(scheduleDto, RecordStatus.DRAFT);
        return ok(success(ScheduleDto.from(schedule), SCHEDULE_UPDATE).getJson());
    }

    @GetMapping("/schedule/find/{id}")
    public ResponseEntity<JSONObject> findById(@PathVariable Integer id) {

        Schedule schedule = service.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course Id: " + id));

        return ok(success(ScheduleDto.from(schedule)).getJson());
    }

    @GetMapping("/schedule/all")
    public ResponseEntity<JSONObject> findAll(
            @RequestParam(value = "sortBy", defaultValue = "") String sortBy) {
        Map<String, Object> filterMap = new HashMap<>();

        List<ScheduleDto> responses = service.findAll(sortable, sortBy, filterMap)
                .stream()
                .map(ScheduleDto::from)
                .collect(Collectors.toList());

        return ok(success(responses).getJson());
    }

    @GetMapping("/schedule/list")
    public ResponseEntity<JSONObject> getList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sortBy", defaultValue = "") String sortBy,
            @RequestParam(value = "venue", defaultValue = "") String venue
    ) {
        PaginatedResponse response = new PaginatedResponse();

        Map<String, Object> scheduleMap = service.getList(venue, page, size, sortBy);
        List<Schedule> schedules = (List<Schedule>) scheduleMap.get("lists");
        List<ScheduleDto> responses = schedules
                .stream()
                .map(ScheduleDto::from)
                .collect(Collectors.toList());

        helper.getCommonData(page, size, scheduleMap, response, responses);

        return ok(success(response).getJson());
    }

    @PutMapping("/schedule/change-record-status/{schedule_id}/{status}")
    public ResponseEntity<JSONObject> changeRecordStatus(@PathVariable Integer schedule_id, @PathVariable RecordStatus status) {

        service.updateRecordStatus(schedule_id, status);
        return ok(success(null, status.toString().toLowerCase() + " successfully").getJson());
    }*/
}
