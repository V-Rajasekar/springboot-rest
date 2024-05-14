package com.raj.api.todo.repository;

import com.raj.api.todo.entity.ToDoItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DataJpaTest
public class ToDoRepositoryTest {

    @Autowired
    ToDoRepository repository;

    @Test
    public void testSaveTodo() {
        ToDoItem toDoItem  = new ToDoItem();
        toDoItem.setName("Prepare Maven");
        toDoItem.setCompleted(true);
        repository.save(toDoItem);

        ToDoItem prepareMaven = repository.getByName("Prepare Maven");
        assertThat(prepareMaven.isCompleted(), equalTo(true));

    }

}
