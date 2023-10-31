package com.ricardo.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TeamDO {

    private long id;
    private String name;

    private String alias;

    private String industry;

    private String logo;

    private String link;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;
}
