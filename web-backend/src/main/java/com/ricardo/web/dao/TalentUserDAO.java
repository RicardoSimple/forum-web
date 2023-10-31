package com.ricardo.web.dao;

import com.ricardo.web.dto.TalentUserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TalentUserDAO {

    int insertTalentUser(TalentUserDO talentUser);

    int updateTalentUser(TalentUserDO talentUser);

    TalentUserDO findTalentUserById(long id);

    TalentUserDO findTalentUserByUsername(String username);

    int deleteTalentUser(long id);

    TalentUserDO findTalentUserByPhone(String phone);
}
