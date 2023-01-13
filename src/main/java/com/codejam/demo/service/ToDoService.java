package com.codejam.demo.service;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.codejam.demo.pojo.TodoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ToDoService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ToDoService() {
        restTemplate.setInterceptors(Collections.singletonList(new ClientHttpReqInterceptor()));
    }

    public ResponseEntity<?> getRequest(HttpHeaders headers, String url) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return new ResponseEntity<>(responseEntity.getBody(), responseEntity.getStatusCode());
    }

    public ResponseEntity<?> getRequest(String url) throws Exception {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        TodoResponse todoResponse = new ObjectMapper().readValue(responseEntity.getBody(), TodoResponse.class);
        return new ResponseEntity<>(todoResponse, responseEntity.getStatusCode());
    }


}
