package com.ricardo.web.api;

import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.TeamRequestParam;
import com.ricardo.web.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/team")
public class TeamApi {

    @Autowired
    private TeamService teamService;

    @PostMapping("/add")
    public Result addTeam(@RequestBody TeamRequestParam param){
        return teamService.addTeam(param);
    }

}
