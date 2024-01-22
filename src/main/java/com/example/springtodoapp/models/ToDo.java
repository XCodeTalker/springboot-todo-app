package com.example.springtodoapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @JsonProperty("id")
    private Long id;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private Boolean completed = Boolean.FALSE;

}