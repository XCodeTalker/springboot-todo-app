package com.example.springtodoapp.domain.todo;

import com.example.springtodoapp.models.ToDo;
import com.example.springtodoapp.repositories.ToDoRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class ToDoRepositoryIntegrationTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @Test
    public void testSaveToDo() {
        //Given
        ToDo toDo = new ToDo();
        toDo.setContent("Test ToDo");
        toDo.setCompleted(false);

        //When
        toDoRepository.deleteAll();
        toDoRepository.save(toDo);

        //Then
        List<ToDo> toDos = toDoRepository.findAll();
        assertEquals(1, toDos.size());
        ToDo savedToDo = toDos.get(0);
        assertEquals("Test ToDo", savedToDo.getContent());
        assertEquals(false, savedToDo.getCompleted());
    }


}
