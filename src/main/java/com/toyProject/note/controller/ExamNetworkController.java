package com.toyProject.note.controller;

import com.toyProject.note.Service.ExamNetworkService;
import com.toyProject.note.model.ExamNetwork;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // 생성자 자동 생성
@RestController
@Slf4j
public class ExamNetworkController {

    ExamNetwork examNetwork; //빈으로 등록을 안 했기 때문에 의존성 주입이라는 개념이 필요가 없음.
    //필드로 가져갈 경우 멀티 스레드가 되면 동일성이 보장되지 않지 않은가.

    @Autowired // 의존 관레를 자동으로 설정(service 객체 주입)
    ExamNetworkService examNetworkService;


    @GetMapping("/examNetwork/selectExamAll" )
    public List<ExamNetwork> selectExamAll(){
        List<ExamNetwork> examNetworks = examNetworkService.selectExamAll();
        return examNetworks;
    }

    @PostMapping("/examNetwork/insert") //RequestMapping(Method=RequestMethod.POST)와 같음.
    public ResponseEntity<Void> insertExamNetwork(@RequestBody ExamNetwork examNetwork){
        log.debug("parmeter {}", examNetwork);
        Integer result = examNetworkService.insertExamNetwork(examNetwork);
        if(result.equals(1)) return ResponseEntity.status(HttpStatus.CREATED).build(); // 수정 완료
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); //수정 실패
    }



}
