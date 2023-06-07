package com.toyProject.note.mapper;

import com.toyProject.note.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int register(User user);
    User login(User user);
}
