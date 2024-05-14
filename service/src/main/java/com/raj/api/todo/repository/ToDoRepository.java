package com.raj.api.todo.repository;

import com.raj.api.todo.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoItem, Long> {

    ToDoItem getByName(String name);
}