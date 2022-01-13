package com.codejam.demo.repository;

import com.codejam.demo.model.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, Integer> {
}
