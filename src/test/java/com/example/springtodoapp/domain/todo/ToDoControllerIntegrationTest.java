package com.example.springtodoapp.domain.todo;

import com.example.springtodoapp.controller.ToDoController;
import com.example.springtodoapp.models.ToDo;
import com.example.springtodoapp.services.ToDoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ToDoControllerIntegrationTest {

    private MockMvc mockMvc;

    @Mock
    private ToDoService toDoService;

    @InjectMocks
    private ToDoController toDoController;

    public ToDoControllerIntegrationTest() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(toDoController).build();
    }

    @Test
    public void testSaveToDo() throws Exception {
        ToDo toDo = new ToDo();
        toDo.setContent("Test ToDo");

        when(toDoService.saveToDo(any(ToDo.class))).thenReturn(toDo);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/todos")
                        .content(asJsonString(toDo))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Test ToDo"));
    }

    // Helper method to convert objects to JSON string
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
