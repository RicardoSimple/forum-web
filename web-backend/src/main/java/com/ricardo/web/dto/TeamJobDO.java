package com.ricardo.web.dto;

import cn.hutool.Hutool;
import com.ricardo.web.model.TeamJob;
import lombok.Data;

@Data
public class TeamJobDO {
    private long id;

    private String jobName;

    private String teamId;

    private String desc;

    private String content;

    private String type;

    private String tags;

    public TeamJob toTeamJob(){
        TeamJob teamJob = new TeamJob();
        teamJob.setJobName(this.jobName);
        teamJob.setTeamId(this.teamId);
        teamJob.setType(this.type);
        teamJob.setDesc(this.desc);
        teamJob.setContent(this.content);
        teamJob.setTags(this.tags.split("|"));
        return teamJob;
    }
}
