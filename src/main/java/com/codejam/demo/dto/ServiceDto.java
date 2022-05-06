package com.codejam.demo.dto;

import lombok.Data;

@Data
public class ServiceDto {

    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;
}
