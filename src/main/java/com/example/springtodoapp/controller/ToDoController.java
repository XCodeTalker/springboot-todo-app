package com.example.springtodoapp.controller;

import com.example.springtodoapp.models.ToDo;
import com.example.springtodoapp.services.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private final ToDoService toDoService;

    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoService.getAllToDos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        Optional<ToDo> toDo = toDoService.getToDoByID(id);
        return toDo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ToDo> saveToDo(@RequestBody ToDo toDo) {
        ToDo savedToDo = toDoService.saveToDo(toDo);
        return ResponseEntity.ok(savedToDo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updatedToDoById(@PathVariable Long id, @RequestBody ToDo updatedToDo) {
        ToDo result = toDoService.updateTodoById(id, updatedToDo);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoById(@PathVariable Long id) {
        Optional<ToDo> toDo = toDoService.getToDoByID(id);
        if (toDo.isPresent()) {
            toDoService.deleteToDoById(toDo.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
