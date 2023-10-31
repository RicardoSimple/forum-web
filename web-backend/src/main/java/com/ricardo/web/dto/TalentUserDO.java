package com.ricardo.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TalentUserDO {
    private long id;

    private String name;

    private String phone;

    private String nickName;

    private String avatar;

    private String email;

    private String status;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;
}
