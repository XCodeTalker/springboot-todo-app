package com.example.springtodoapp.domain.todo;

import com.example.springtodoapp.models.ToDo;
import com.example.springtodoapp.repositories.ToDoRepository;
import com.example.springtodoapp.services.ToDoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ToDoServiceIntegrationTest {

    @Mock
    private ToDoRepository toDoRepository;

    @InjectMocks
    private ToDoService toDoService;

    @Test
    void saveToDo() {
        // Given
        ToDo todoToSave = new ToDo();
        todoToSave.setContent("Test Content");
        todoToSave.setCompleted(false);

        ToDo savedToDo = new ToDo();
        savedToDo.setId(1L);
        savedToDo.setContent("Test Content");
        savedToDo.setCompleted(false);

        // Configure the save method to return the saved ToDo
        when(toDoRepository.save(todoToSave)).thenReturn(savedToDo);

        // When
        ToDo result = toDoService.saveToDo(todoToSave);

        // Then
        assertEquals(savedToDo, result);
        verify(toDoRepository).save(todoToSave);
    }
}
