package com.ricardo.web.service.impl;

import com.ricardo.web.dao.TeamJobDAO;
import com.ricardo.web.dto.TeamJobDO;
import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.TeamJobParam;
import com.ricardo.web.service.TeamJobService;
import com.ricardo.web.util.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamJobServiceImpl implements TeamJobService {

    @Autowired
    private TeamJobDAO teamJobDAO;
    @Override
    public Result addOrUpdateTeamJob(TeamJobParam param) {
        if (param.getTeamId().isBlank()){
            return Result.fail(Code.FAIL_NO_DATA,"team_id为空");
        }
        TeamJobDO teamJobDO = new TeamJobDO();
        teamJobDO.setTeamId(Long.parseLong(param.getTeamId()));
        teamJobDO.setJobName(param.getJobName());
        teamJobDO.setTags(String.join("|", param.getTags()));
        teamJobDO.setType(param.getType());
        teamJobDO.setDesc(param.getDesc());
        teamJobDO.setContent(param.getContent());
        teamJobDO.setCount(param.getCount());

        if (param.getId().isBlank()) {
            teamJobDAO.insertTeamJob(teamJobDO);
        }else {
            teamJobDO.setId(Long.parseLong(param.getId()));
            teamJobDAO.updateTeamJob(teamJobDO);
        }

        return Result.success(null);
    }
}
