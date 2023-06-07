package com.toyProject.note.model;

import lombok.Data;

import java.util.Date;

@Data
public class Todo {
    private int todoId;
    private int userId;
    private String todoTitle;
    private String todoDescription;
    private Date todoWriteDate;
    private Date todoDueDate;
    private int todoCompleted;
    private int todoDaily;
}
