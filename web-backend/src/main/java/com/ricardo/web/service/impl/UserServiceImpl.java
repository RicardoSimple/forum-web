package com.ricardo.web.service.impl;

import com.ricardo.web.dao.TalentUserDAO;
import com.ricardo.web.dao.TeamUserDAO;
import com.ricardo.web.dto.TalentUserDO;
import com.ricardo.web.dto.TeamUserDO;
import com.ricardo.web.model.Result;
import com.ricardo.web.model.param.UserRegisterRequest;
import com.ricardo.web.service.UserService;
import com.ricardo.web.util.Code;
import com.ricardo.web.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TalentUserDAO talentUserDAO;

    @Autowired
    private TeamUserDAO teamUserDAO;

    @Override
    public Result registerUser(UserRegisterRequest request) {
        // 实现用户注册逻辑
        if (request.getPhone().isBlank()){
            return Result.fail(Code.FAIL_DUPLICATE,"需要输入手机号");
        }
        // 1. 判断用户类型
        if (request.getUserType().equals(Const.TALENT_TYPE)) {
            // 人才类型
            TalentUserDO talentUserDO = talentUserDAO.findTalentUserByPhone(request.getPhone());
            if(talentUserDO!=null&&talentUserDO.getPhone().equals(request.getPhone())){
                return Result.fail(Code.FAIL_DUPLICATE,"手机号重复");
            }
            talentUserDO = new TalentUserDO();
            talentUserDO.setAvatar(request.getAvatar());
            talentUserDO.setEducation(request.getEducation());
            talentUserDO.setPhone(request.getPhone());
            talentUserDO.setEmail(request.getEmail());
            talentUserDO.setName(request.getName());
            talentUserDO.setPwd(request.getPwd());
            talentUserDO.setNickName(request.getNickName());
            talentUserDO.setStatus(request.getStatus());

            talentUserDAO.insertTalentUser(talentUserDO);
            return Result.success(null);
        }
        // team类型
        TeamUserDO teamUserDO = teamUserDAO.findTeamUserByPhone(request.getPhone());
        if(teamUserDO!=null&&teamUserDO.getPhone().equals(request.getPhone())){
            return Result.fail(Code.FAIL_DUPLICATE,"手机号重复");
        }
        teamUserDO = new TeamUserDO();
        teamUserDO.setAvatar(request.getAvatar());
        teamUserDO.setEmail(request.getEmail());
        teamUserDO.setPhone(request.getPhone());
        teamUserDO.setName(request.getName());
        teamUserDO.setPwd(request.getPwd());
        teamUserDO.setNickName(request.getNickName());
        teamUserDO.setTeamId(request.getTeamId());
        teamUserDO.setRole(request.getRole());

        teamUserDAO.insertTeamUser(teamUserDO);

        return Result.success(null);
    }
}
