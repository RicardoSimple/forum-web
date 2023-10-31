package com.ricardo.web.model;

import lombok.Data;

@Data
public class TeamJob {

    private String jobName;

    private String teamId;

    private String desc;

    private String content;

    private String type;

    private String[] tags;

}
