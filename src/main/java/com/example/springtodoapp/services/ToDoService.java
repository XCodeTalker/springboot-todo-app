package com.example.springtodoapp.services;

import com.example.springtodoapp.models.ToDo;
import com.example.springtodoapp.repositories.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ToDoService {

    @Autowired
    private final ToDoRepository toDoRepository;

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> getToDoByID(Long id) {
        return toDoRepository.findById(id);
    }

    public ToDo saveToDo(ToDo todo) {
        return toDoRepository.save(todo);
    }

    public ToDo updateTodoById(Long id, ToDo updatedToDo) {
        ToDo existingToDo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found with id: " + id));

        existingToDo.setContent(updatedToDo.getContent());
        existingToDo.setCompleted(updatedToDo.getCompleted());

        return toDoRepository.save(existingToDo);
    }

    public void deleteToDoById(ToDo toDo) {
        toDoRepository.delete(toDo);
    }

}
