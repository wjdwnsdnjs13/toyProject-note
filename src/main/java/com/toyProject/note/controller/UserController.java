package com.toyProject.note.controller;

import com.toyProject.note.Service.UserService;
import com.toyProject.note.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor // 생성자 자동 생성
@RestController
@Slf4j
public class UserController {

    User user; //빈으로 등록을 안 했기 때문에 의존성 주입이라는 개념이 필요가 없음.
    //필드로 가져갈 경우 멀티 스레드가 되면 동일성이 보장되지 않지 않은가.

    @Autowired // 의존 관레를 자동으로 설정(service 객체 주입)
    UserService userService;


    @GetMapping("/start" ) //RequestMapping(Method=RequestMethod.POST)와 같음.
    public void start(@RequestParam Map<String, String> object){ //ResponseEntity<Void>하면 body에 제네릭이 들어감
        log.debug("hi");
        for(String str: object.keySet()) log.debug("오브젝트 이거임 : {}", object.get(str));
        return;
    }

    @PostMapping("/signUp") //RequestMapping(Method=RequestMethod.POST)와 같음.
    public ResponseEntity<Void> signUp(@RequestBody User user){ //ResponseEntity<Void>하면 body에 제네릭이 들어감
        Integer result = userService.joinUser(user);
        if(result.equals(1)) return ResponseEntity.status(HttpStatus.CREATED).build(); // 회원 가입 성공
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); //회원 가입 실패
    }


    @PostMapping("/note/login")
    public ResponseEntity<Void> login(@RequestBody User user){
        log.debug("이게 왜 오류임 {}", user.toString());
        //여기서 검증하기 위해 user 필드를 사용하는 것도 불필요해 보이고(최초 로그인 요청 전까지는 계속 null 상태로 떠다니 잖아)
        // 애초에 loginUser의 리턴 값이 boolean 타입이면 될 거 같음.
        User user1 = userService.loginUser(user);
        if(user1 != null) return ResponseEntity.status(HttpStatus.OK).build();
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }



}
