package com.ricardo.web.dto;

import cn.hutool.Hutool;
import com.ricardo.web.model.TeamJob;
import lombok.Data;

@Data
public class TeamJobDO {
    private long id;

    private String jobName;

    private long teamId;

    private String desc;

    private String content;

    private String type;

    private String tags;

    private int count;

    public TeamJob toTeamJob(){
        TeamJob teamJob = new TeamJob();
        teamJob.setId(this.id);
        teamJob.setJobName(this.jobName);
        teamJob.setTeamId(this.teamId);
        teamJob.setType(this.type);
        teamJob.setDesc(this.desc);
        teamJob.setContent(this.content);
        teamJob.setTags(this.tags.split("|"));
        teamJob.setCount(this.count);
        return teamJob;
    }
}
