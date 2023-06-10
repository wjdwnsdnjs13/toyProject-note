package com.toyProject.note.controller;

import com.toyProject.note.Service.ToDoService;
import com.toyProject.note.model.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ToDoController {
    Todo todo;

    @Autowired
    private ToDoService toDoService;


    @GetMapping("/note/all" ) //RequestMapping(Method=RequestMethod.POST)와 같음.
    public List<Todo> noteSelectAll(){ //ResponseEntity<Void>하면 body에 제네릭이 들어감
        List<Todo> todoList = toDoService.selectNoteAll();
        return todoList;
    }

    @GetMapping("/note/todoCompleted")
    public ResponseEntity<Void> todoCompleted(@RequestParam("todoId") Long todoId){
        Integer result = toDoService.todoCompleted(todoId);
        log.debug("todoCompleted 실행됨 {}", result);
        if(result > 0) return ResponseEntity.status(HttpStatus.OK).build();
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/note/todoNoneCompleted")
    public ResponseEntity<Void> todoNoneCompleted(@RequestParam("todoId") Long todoId){
        Integer result = toDoService.todoNoneCompleted(todoId);
        log.debug("todoNoneCompleted 실행됨 {}", result);
        if(result > 0) return ResponseEntity.status(HttpStatus.OK).build();
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/note/todoDelete")
    public ResponseEntity<Void> todoDelete(@RequestParam("todoId") Long todoId){
        Integer result = toDoService.todoDelete(todoId);
        log.debug("todoDelete 실행됨 {}", result);
        if(result > 0) return ResponseEntity.status(HttpStatus.OK).build();
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/note/todoInsert")
    public ResponseEntity<Void> todoInsert(@RequestBody Todo todo){
        todo.setTodoWriteDate(new Date());
        todo.setUserNo(1);
        log.debug("생성된 todo 객체 {}", todo.toString());
        Integer result = toDoService.todoInsert(todo);
        if(result > 0) return ResponseEntity.status(HttpStatus.OK).build();
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
