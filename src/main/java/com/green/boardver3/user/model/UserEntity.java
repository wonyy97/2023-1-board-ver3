package com.green.boardver3.user.model;
import lombok.Data;
@Data
public class UserEntity {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private char gender;
    private String addr;
    private String main_pic;
    private String created_at;
    private String updated_at;
}