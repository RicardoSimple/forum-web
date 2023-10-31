package com.ricardo.web.model.param;

import lombok.Data;

@Data
public class UserRegisterRequest {
    // 用户注册参数
    private String userType;

    private String name;

    private String nickName;

    private String phone;

    private String avatar;

    private String email;

    private String pwd;

    private String status;

    private String education;

    private String teamId;

    private String role;

}
