package com.ricardo.web.dao;

import com.ricardo.web.dto.TeamJobDO;
import com.ricardo.web.model.TeamJob;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TeamJobDAO {

    void insertTeamJob(TeamJobDO teamJob);

    void updateTeamJob(TeamJobDO teamJob);

    TeamJob findTeamJobById(long id);

    List<TeamJob> findTeamJobsByTeamId(String teamId);

    void deleteTeamJob(long id);

}
