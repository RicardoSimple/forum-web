package com.ricardo.web.dao;

import com.ricardo.web.dto.CommentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDAO {
    void insertMessage(CommentDO commentDO);
    void updateMessage(CommentDO commentDO);
    CommentDO findMessageById(long Id);
    void deleteMessage(long Id);

    List<CommentDO> findMessageByUserIdAndType(CommentDO commentDO);

}
