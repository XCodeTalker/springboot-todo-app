package com.example.springtodoapp.domain.todo;

import com.example.springtodoapp.models.ToDo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToDoTest {


    @Test
    public void testCreateToDo() {
        ToDo toDo = new ToDo();
        toDo.setId(1L);
        toDo.setContent("Example Content");
        toDo.setCompleted(true);

        Assertions.assertEquals(1L, toDo.getId());
        Assertions.assertEquals("Example Content", toDo.getContent());
        Assertions.assertTrue(toDo.getCompleted());
    }

    @Test
    public void testDefaultValues() {
        ToDo toDo = new ToDo();

        Assertions.assertNull(toDo.getId());
        Assertions.assertNull(toDo.getContent());
        Assertions.assertFalse(toDo.getCompleted());
    }

}
