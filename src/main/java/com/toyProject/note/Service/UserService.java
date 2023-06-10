package com.toyProject.note.Service;

import com.toyProject.note.mapper.UserMapper;
import com.toyProject.note.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //생성자 자동 생성
public class UserService {

    //Autowired 안해주면 생성자 주입이 되지 않기 때문에 NullPointerException이 뜨므로 주의할 것.
    @Autowired
    UserMapper userMapper;

    @Transactional // 트랜잭션 보장이 된 메소드로 설정해줌.
    public int joinUser(User user){
        return userMapper.register(user);
    }

    public User loginUser(User user){
        return userMapper.login(user);
    }
}
