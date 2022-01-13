package com.codejam.demo.model;

import com.codejam.demo.dto.TodoDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TODO", schema = "testdb")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "title")
    private String title;

    @Column(name = "completed")
    private boolean completed;

    public TodoDto toEntity() {
        TodoDto entity = new TodoDto();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }
}
