package com.ricardo.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TeamUserDO {

    private long id;

    private String name;

    private String phone;

    private String nickName;

    private String avatar;

    private String pwd;

    private String email;

    private String teamId;

    private String role;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;
}
