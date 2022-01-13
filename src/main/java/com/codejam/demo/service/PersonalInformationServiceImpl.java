package com.codejam.demo.service;

import com.codejam.demo.dto.PersonalInformationDto;
import com.codejam.demo.dto.ResponseDto;
import com.codejam.demo.dto.TodoDto;
import com.codejam.demo.exception.DataNotFoundException;
import com.codejam.demo.exception.ExternalCallException;
import com.codejam.demo.model.PersonalInformationEntity;
import com.codejam.demo.model.TodoEntity;
import com.codejam.demo.repository.PersonalInformationRepository;
import com.codejam.demo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class PersonalInformationServiceImpl implements PersonalInformationService {

    @Value("${external.url.todo}")
    private String url;

    private final PersonalInformationRepository personalInformationRepository;
    private final TodoRepository todoRepository;

    @Autowired
    public PersonalInformationServiceImpl(PersonalInformationRepository personalInformationRepository,
                                          TodoRepository todoRepository) {
        this.personalInformationRepository = personalInformationRepository;
        this.todoRepository = todoRepository;
    }

    /**
     * @param dto json object for personal details
     * @return a success response object with status message
     */
    @Transactional
    @Override
    public ResponseEntity<ResponseDto> save(PersonalInformationDto dto) {

        log.info("INVOKED PERSONAL DETAILS SAVING METHOD");

        TodoDto todoDto = getTodoDto(dto);

        PersonalInformationEntity personalInformationEntity = dto.toEntity();

        TodoEntity todoEntity = todoDto.toEntity();

        personalInformationRepository.save(personalInformationEntity);
        todoRepository.save(todoEntity);

        log.info("COMPLETED PERSONAL DETAILS SAVING METHOD");

        ResponseDto response = new ResponseDto();
        response.setMessage("Data saved successfully");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<PersonalInformationDto> get(Integer id) {

        log.info("INVOKED PERSONAL DETAILS GET METHOD");

        PersonalInformationEntity entity = personalInformationRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Record can not be found", String.valueOf(id)));

        log.info("COMPLETED PERSONAL DETAILS GET METHOD");

        return ResponseEntity.status(HttpStatus.OK).body(entity.toDto());
    }

    /**
     * @param dto json object for personal details
     * @return a success response object with status message
     */
    @Transactional
    @Override
    public ResponseEntity<ResponseDto> update(PersonalInformationDto dto) {

        log.info("INVOKED PERSONAL DETAILS UPDATING METHOD");

        PersonalInformationEntity entity = personalInformationRepository.findById(dto.getId())
                .orElseThrow(() -> new DataNotFoundException("Record can not be found", String.valueOf(dto.getId())));

        entity.setDateTime(dto.getDateTime());
        entity.setId(dto.getId());
        entity.setIdolName(dto.getIdolName());
        entity.setIdolStatus(dto.getIdolStatus());
        entity.setRealName(dto.getRealName());

        TodoDto todoDto = getTodoDto(dto);
        TodoEntity todoEntity = todoDto != null ? todoDto.toEntity() : null;

        personalInformationRepository.save(entity);
        assert todoEntity != null;
        todoRepository.save(todoEntity);

        log.info("COMPLETED PERSONAL DETAILS UPDATING METHOD");

        ResponseDto response = new ResponseDto();
        response.setMessage("Data updated successfully");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<ResponseDto> delete(Integer id) {

        log.info("INVOKED PERSONAL DETAILS DELETING METHOD");

        personalInformationRepository.deleteById(id);

        ResponseDto response = new ResponseDto();
        response.setMessage("Data deleted successfully");

        log.info("COMPLETED PERSONAL DETAILS DELETING METHOD");

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    /**
     * @param dto json object for personal details
     * @return a todo object with status message
     */
    private TodoDto getTodoDto(PersonalInformationDto dto) {

        TodoDto todoDto;

        // From java 11 we can use webclient instead of rest template
        RestTemplate restTemplate = new RestTemplate();

        try {
            todoDto = restTemplate
                    .getForObject(url.concat("/".concat(String.valueOf(dto.getTodoId()))), TodoDto.class);

        } catch (Exception e) {
            log.error("ERROR WHILE PERSONAL DETAILS SAVING METHOD");
            throw new ExternalCallException("Error occurred while getting data", url);
        }
        return todoDto;
    }

}
