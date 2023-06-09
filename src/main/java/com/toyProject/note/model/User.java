package com.toyProject.note.model;

import lombok.Data;

@Data
public class User {
    private int userNo;
    private String userId;
    private String userName;
    private String userEmail;
    private String userPw;
    private String userSnsId;
    private String userSnsProvider;
    private int userType;

    public User(){}
    public User(String userId, String userPw){
        this.userId = userId;
        this.userPw = userPw;
    }


}
