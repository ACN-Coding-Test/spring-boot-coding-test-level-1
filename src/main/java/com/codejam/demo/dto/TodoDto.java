package com.codejam.demo.dto;

import com.codejam.demo.model.TodoEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class TodoDto {

    private Integer userId;

    private Integer id;

    private String title;

    private boolean completed;

    public TodoEntity toEntity() {
        TodoEntity entity = new TodoEntity();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }
}
