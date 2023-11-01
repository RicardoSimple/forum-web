package com.ricardo.web.dao;

import com.ricardo.web.model.TeamJob;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TeamJobDAO {

    void insertTeamJob(TeamJob teamJob);

    void updateTeamJob(TeamJob teamJob);

    TeamJob findTeamJobById(long id);

    List<TeamJob> findTeamJobsByTeamId(String teamId);

    void deleteTeamJob(long id);

}
