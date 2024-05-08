package com.rajasekar.api.todo.repository;

import com.rajasekar.api.todo.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoItem, Long> {

    ToDoItem getByName(String name);
}