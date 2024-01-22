package com.example.springtodoapp.domain.todo;

import com.example.springtodoapp.models.ToDo;

import java.util.ArrayList;
import java.util.List;

public class ToDoDummy {

    public static ToDo defaultTodo() {
        return new ToDo(1L,"TestContent", false);
    }

    public static List<ToDo> defaultToDoList() {
        ArrayList<ToDo> toDos = new ArrayList<>();
        toDos.add(new ToDo(1L,"FirstContent", false));
        toDos.add(new ToDo(2L,"SecondContent", false));
        toDos.add(new ToDo(3L,"ThirdContent", false));
        return toDos;
    }


}
