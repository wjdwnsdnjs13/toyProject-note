package com.toyProject.note.Service;

import com.toyProject.note.mapper.ToDoMapper;
import com.toyProject.note.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ToDoService {

    @Autowired
    private ToDoMapper toDoMapper;

    @Transactional
    public List<Todo> selectNoteAll(){

        return toDoMapper.selectNoteAll();
    };

    @Transactional
    public Integer todoCompleted(Long todoId){
        return toDoMapper.todoCompleted(todoId);
    }

    @Transactional
    public Integer todoNoneCompleted(Long todoId){
        return toDoMapper.todoNoneCompleted(todoId);
    }

    @Transactional
    public Integer todoDelete(Long todoId){
        return toDoMapper.todoDelete(todoId);
    }

    @Transactional
    public Integer todoInsert(Todo todo){
        return toDoMapper.todoInsert(todo);
    }
}
