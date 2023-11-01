package com.ricardo.web.dto;

import com.ricardo.web.model.TeamUser;
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

    public TeamUser toUser() {
        TeamUser teamUser = new TeamUser();
        teamUser.setTeamId(this.teamId);
        teamUser.setRole(this.role);
        teamUser.setAvatar(this.avatar);
        teamUser.setName(this.name);
        teamUser.setEmail(this.email);
        teamUser.setPhone(this.phone);
        return teamUser;
    }
}
