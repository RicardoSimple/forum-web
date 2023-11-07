package com.ricardo.web.dao;

import com.ricardo.web.dto.CommentDO;
import com.ricardo.web.dto.TeamJobDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDAO {
    static List<CommentDO> findAllComment() {
        return null;
    }

    void insertMessage(CommentDO commentDO);
    void updateMessage(CommentDO commentDO);

    static CommentDO findMessageById(long Id) {
        return null;
    }

    void deleteMessage(long Id);

    List<TeamJobDO> findMessageByTeamId(Long Id);

}
