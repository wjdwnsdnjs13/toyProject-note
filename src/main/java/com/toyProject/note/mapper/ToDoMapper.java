package com.toyProject.note.mapper;


import com.toyProject.note.model.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToDoMapper {
    List<Todo> selectNoteAll();
    Integer todoCompleted(Long todoId);
    Integer todoNoneCompleted(Long todoId);
    Integer todoDelete(Long todoId);
    Integer todoInsert(Todo todo);
}
